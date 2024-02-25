package com.example.hospitaljpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String specialite ;
    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    //Quand tu me donne medecin cest pas necessaire de me donner la liste des RendezVous
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//tient compte de l'enregistrement et la no la lecture
    private Collection<RendezVous> rendezVous ;
}
