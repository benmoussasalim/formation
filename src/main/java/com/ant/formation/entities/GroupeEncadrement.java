package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class GroupeEncadrement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    @ManyToMany
    private List<Candidat> candidats;
    @OneToMany(mappedBy = "groupeEncadrement")
    private List<Planing> planings;

    @OneToMany(mappedBy = "groupeEncadrement")
    private List<Paiment> paiments;
}
