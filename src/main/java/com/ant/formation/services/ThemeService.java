package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Theme;

import java.util.List;

public interface ThemeService {
    public MessageResponse save(Theme theme);
    public MessageResponse update(Theme theme);
    public MessageResponse delete(Integer id);
    public List<Theme> findAll();
    public Theme findByLibelle(String libelle);

}
