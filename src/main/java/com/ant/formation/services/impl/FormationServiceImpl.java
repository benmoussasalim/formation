package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formation;
import com.ant.formation.enums.StatusFormation;
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
    	formation.setStatusFormation(StatusFormation.EN_ATTENTE);
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
        boolean exist = formationRepository.existsById(id);
        if (!exist) {
            return new MessageResponse(false, "Attention",
                    "Formation n'existe pas");
        }


        exist =    formationRepository.existsByIdAndCandidatFormationsIsNotNullOrPlaningsIsNotNull(id);
        if (exist) {
            return new MessageResponse(false, "Attention",
                    "Formation affectée a un ou plusieurs plannings ou candidats");
        }

        formationRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Formation> findByStatus(StatusFormation statusFormation) {
        return formationRepository.findByStatusFormation(statusFormation);
    }

	@Override
	public Formation findById(Integer id) {
		// TODO Auto-generated method stub
		return formationRepository.findById(id).orElse(null);
	}

}
