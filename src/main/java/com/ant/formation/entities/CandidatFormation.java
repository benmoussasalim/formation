package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class CandidatFormation {
    @EmbeddedId
    private CandidatFormationId id;
    private double tarif;
    @ManyToOne
    @JoinColumn(name = "formation_id", insertable = false, updatable = false)
    private Formation formation;

    @ManyToOne
    @JoinColumn(name = "candidat_id", insertable = false, updatable = false)
    private Candidat candidat;
}
