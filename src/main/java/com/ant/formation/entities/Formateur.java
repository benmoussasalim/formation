package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Data
public class Formateur extends Personne {

	@JsonIgnore
    @OneToMany(mappedBy = "formateur")
    private List<Formation> formations;

    @OneToMany(mappedBy = "formateur")
    private List<FormateurTheme> formateurThemes;
}
