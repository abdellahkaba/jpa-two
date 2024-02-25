package com.example.hospitaljpa.repositories;

import com.example.hospitaljpa.entities.Consultation;
import com.example.hospitaljpa.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
