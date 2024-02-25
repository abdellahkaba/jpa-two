package com.example.hospitaljpa.services;

import com.example.hospitaljpa.entities.Consultation;
import com.example.hospitaljpa.entities.Medecin;
import com.example.hospitaljpa.entities.Patient;
import com.example.hospitaljpa.entities.RendezVous;
import com.example.hospitaljpa.repositories.ConsultationRepository;
import com.example.hospitaljpa.repositories.MedecinRepository;
import com.example.hospitaljpa.repositories.PatientRepository;
import com.example.hospitaljpa.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    /*
    * On initialise toutes les interfaces pour faire l'injection de dependance
    * soit par @Autowird ou par le constructeur pour instancier tous les repository
    * */

    private PatientRepository patientRepository ;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository ;
    private ConsultationRepository consultationRepository ;

    public IHospitalServiceImpl(
            PatientRepository patientRepository,
            MedecinRepository medecinRepository,
            RendezVousRepository rendezVousRepository,
            ConsultationRepository consultationRepository)
    {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
