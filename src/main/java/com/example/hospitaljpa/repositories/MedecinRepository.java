package com.example.hospitaljpa.repositories;

import com.example.hospitaljpa.entities.Medecin;
import com.example.hospitaljpa.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
