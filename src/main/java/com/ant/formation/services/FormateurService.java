package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;

import java.util.List;

public interface FormateurService {
    public MessageResponse save(Formateur formateur);
    public MessageResponse update(Formateur formateur);
    public MessageResponse delete(Integer id);
    public List<Formateur> findAll();
    public Formateur findByID(Integer id);

}
