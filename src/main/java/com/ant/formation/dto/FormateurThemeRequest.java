package com.ant.formation.dto;

import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Theme;
import lombok.Data;

import java.util.List;

@Data
public class FormateurThemeRequest {
    private  Formateur formateur;
    private List<Theme> themes;
}
