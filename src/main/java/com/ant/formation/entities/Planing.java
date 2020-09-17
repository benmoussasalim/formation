package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Planing implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private Formation formation;
    @ManyToMany
    private List<Salle> salles;
    @ManyToOne
    private GroupeEncadrement groupeEncadrement;
}
