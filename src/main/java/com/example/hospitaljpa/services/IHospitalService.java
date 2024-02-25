package com.example.hospitaljpa.services;

import com.example.hospitaljpa.entities.Consultation;
import com.example.hospitaljpa.entities.Medecin;
import com.example.hospitaljpa.entities.Patient;
import com.example.hospitaljpa.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation (Consultation consultation);
}
