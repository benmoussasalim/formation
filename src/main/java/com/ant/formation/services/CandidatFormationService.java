package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.CandidatFormation;

import java.util.List;

public interface CandidatFormationService {
    public MessageResponse save(CandidatFormation candidatFormation);
    public MessageResponse update(CandidatFormation candidatFormation);
    public MessageResponse delete(Integer id);
    public List<CandidatFormation> findAll();

}
