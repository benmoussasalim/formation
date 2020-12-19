package com.ant.formation.services;

import java.util.List;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.CandidatFormation;

public interface CandidatFormationService {
    public MessageResponse save(List<CandidatFormation> candidatFormations );
    public MessageResponse update(CandidatFormation candidatFormation);
    public MessageResponse delete(Integer id);
    public List<CandidatFormation> findCandidatByFormation(Integer id);
    public List<Candidat> findCandidatNotInFormation(Integer id);
}
