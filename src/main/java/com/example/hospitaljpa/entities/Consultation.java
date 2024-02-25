package com.example.hospitaljpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateConsultation;
    private String rapport ;
    @OneToOne
    //Quand tu me donne les info de Consultation cest pas necessaire de me donner la liste des RendezVous
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//tient compte de l'enregistrement et la no la lecture
    private RendezVous rendezVous ;
}
