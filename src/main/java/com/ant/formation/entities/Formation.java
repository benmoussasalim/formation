package com.ant.formation.entities;

import com.ant.formation.enums.StatusFormation;
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
    @Temporal(TemporalType.DATE)
    private Date dateDebutPrevu;
    @Temporal(TemporalType.DATE)
    private Date dateFinPrevu;
    @Temporal(TemporalType.DATE)
    private Date dateDebutReel;
    @Temporal(TemporalType.DATE)
    private Date dateFinReel;
    private int nbrHeur;
    private double prix;
    @Enumerated(EnumType.STRING)
    private StatusFormation statusFormation;
    @ManyToOne
    private Theme theme;
    @ManyToOne
    private Formateur formateur;

    @OneToMany(mappedBy = "formation")
    private List<Planing> planings;


}
