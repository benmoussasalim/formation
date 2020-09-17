package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Salle;

import java.util.List;

public interface SalleService {
    public MessageResponse save(Salle salle);
    public MessageResponse update(Salle salle);
    public MessageResponse delete(Integer id);
    public List<Salle> findAll();

}
