package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private Date dateDebutPrevu;
    private Date dateFinPrevu;
    private Date dateDebutReel;
    private Date dateFinReel;
    private int nbrHeur;
    private double prix;
    @ManyToOne
    private Theme theme;
    @ManyToOne
    private Formateur formateur;

    @OneToMany(mappedBy = "formation")
    private List<Planing> planings;


}
