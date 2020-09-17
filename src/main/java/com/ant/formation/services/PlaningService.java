package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Planing;

import java.util.List;

public interface PlaningService {
    public MessageResponse save(Planing planing);
    public MessageResponse update(Planing planing);
    public MessageResponse delete(String libelle);
    public List<Planing> findAll();


}
