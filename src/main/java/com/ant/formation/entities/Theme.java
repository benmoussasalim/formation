package com.ant.formation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @OneToMany(mappedBy = "theme")
    private List<Formation> formations;
    @JsonIgnore
    @OneToMany(mappedBy = "theme")
    private List<FormateurTheme> formateurThemes;
}
