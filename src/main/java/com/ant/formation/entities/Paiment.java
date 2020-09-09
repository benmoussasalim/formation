package com.ant.formation.entities;

import com.ant.formation.enums.ModePaiment;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Paiment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private ModePaiment modePaiment;
    private Integer nbh;
    private double prixh;
    @ManyToOne
    private Users user;

    @ManyToOne
    private GroupeEncadrement groupeEncadrement;
}
