package com.example.hospitaljpa.repositories;

import com.example.hospitaljpa.entities.Medecin;
import com.example.hospitaljpa.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {
}
