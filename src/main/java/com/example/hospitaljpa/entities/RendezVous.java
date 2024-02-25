package com.example.hospitaljpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id
    private String id ;
    private Date date ;
    @Enumerated(EnumType.STRING)
    private StatusRDV statuts;
    @ManyToOne
    //Quand tu me donne RendezVous cest pas necessaire de me donner la liste des Patients
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//tient compte de l'enregistrement et la no la lecture
    private Patient patient;
    @ManyToOne
    private Medecin medecin ;
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation ;
}
