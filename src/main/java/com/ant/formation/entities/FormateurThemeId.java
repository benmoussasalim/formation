package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FormateurThemeId implements Serializable {
    @Column(name = "id_formateur")
    private Integer idFormateur;
    @Column(name = "id_theme")
    private Integer idTheme;
}
