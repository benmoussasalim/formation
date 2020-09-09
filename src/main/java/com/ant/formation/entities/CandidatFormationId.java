package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CandidatFormationId implements Serializable {
    @Column(name = "candidat_id")
    private Integer candidatId;
    @Column(name = "formation_id")
    private Integer formationId;

}
