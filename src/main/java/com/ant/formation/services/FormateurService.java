package com.ant.formation.services;

import com.ant.formation.dto.FormateurThemeRequest;
import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.FormateurTheme;
import com.ant.formation.entities.Theme;

import java.util.List;

public interface FormateurService {
    public MessageResponse save(FormateurThemeRequest formateurThemeRequest);
    public MessageResponse update(FormateurThemeRequest formateurThemeRequest);
    public MessageResponse delete(Integer id);
    public List<Formateur> findAll();
    public Formateur findByID(Integer id);
    public List<Formateur> findByFormateurThemes(Theme theme);

}
