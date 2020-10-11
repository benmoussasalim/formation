package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formation;
import com.ant.formation.repositories.FormationRepository;
import com.ant.formation.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository formationRepository;

    @Override
    public MessageResponse save(Formation formation) {
        formationRepository.save(formation);
        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Formation formation) {
        formationRepository.save(formation);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(Integer id) {
        boolean exist = formationRepository.existsByIdAndCandidatFormation(id);
        if (exist) {
            return new MessageResponse(false, "Attention",
                    "Formation affecté a un ou plusieurs formations");
        }


        formationRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Formation> findAll() {
        return formationRepository.findAll();
    }
    
}
