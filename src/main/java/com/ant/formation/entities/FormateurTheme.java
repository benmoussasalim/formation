package com.ant.formation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class FormateurTheme {
    @EmbeddedId
    private FormateurThemeId id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_formateur", insertable = false, updatable = false)
    private Formateur formateur;
    @ManyToOne
    @JoinColumn(name = "id_theme", insertable = false, updatable = false)
    private Theme theme;
}
