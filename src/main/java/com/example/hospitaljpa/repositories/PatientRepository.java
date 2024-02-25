package com.example.hospitaljpa.repositories;

import com.example.hospitaljpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    //Cherchons un patient par son nom
    Patient findByNom(String nom);
}
