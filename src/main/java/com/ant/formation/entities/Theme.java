package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Theme implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    @OneToMany(mappedBy = "theme")
    private List<Formation> formations;

    @ManyToMany
    private List<Formateur> formateurs;
}
