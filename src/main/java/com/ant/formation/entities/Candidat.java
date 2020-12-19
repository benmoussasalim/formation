package com.ant.formation.entities;

import com.ant.formation.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Candidat extends Personne  {

    private Date dateInscrit;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String cin;
    private String sexe;
    private String adresse;
    private String niveauEtude;
    private String etablissement;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String societe;
    @JsonIgnore
    @OneToMany(mappedBy = "candidat")
    private List<CandidatFormation> candidatFormations;
    @JsonIgnore
    @ManyToMany(mappedBy = "candidats")
    private List<GroupeEncadrement> groupeEncadrements;


}
