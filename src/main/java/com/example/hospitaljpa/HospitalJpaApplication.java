package com.example.hospitaljpa;

import com.example.hospitaljpa.entities.*;
import com.example.hospitaljpa.repositories.ConsultationRepository;
import com.example.hospitaljpa.repositories.MedecinRepository;
import com.example.hospitaljpa.repositories.PatientRepository;
import com.example.hospitaljpa.repositories.RendezVousRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalJpaApplication.class, args);
    }
  //Pour faire les methodes de test
    //Une methode qui utilise l'annotation bean est une methode qui s'excuter au demmarage

    @Bean
    CommandLineRunner start(
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository
    ){
        return args -> {
            Stream.of("Mohame","Ibrahim","Mariam")
                    .forEach(name -> {
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaiss(new Date());
                        patient.setMalade(false);
                        patientRepository.save(patient);
                    });
            Stream.of("Sarata","Alex","Abacar")
                    .forEach(name -> {
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setSpecialite(Math.random()>0.5? "Cardio": "Pediatre");
                        medecin.setEmail(name+"@gmail.com");
                       // medecin.setEmail(Math.random()>0.5? "aba@gmail.com": "kallo@gmail.com");
                        medecinRepository.save(medecin);
                    });
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Abacar");
            Medecin medecin = medecinRepository.findByNom("Sarata");
            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatuts(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            rendezVousRepository.save(rendezVous);


            //Selectionner d'abord les rendezVous a consulter
            RendezVous rendezVous1 = rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());

            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de consultation");
            consultationRepository.save(consultation);


        };
    }

}
