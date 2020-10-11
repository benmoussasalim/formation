package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.CandidatFormation;

import java.util.List;

public interface CandidatService {
    public MessageResponse save(Candidat candidat);
    public MessageResponse update(Candidat candidat);
    public MessageResponse delete(Integer id);
    public List<Candidat> findAll();
    public List<Candidat> filter(String keyword);
    public Candidat findByID(Integer id);

}
