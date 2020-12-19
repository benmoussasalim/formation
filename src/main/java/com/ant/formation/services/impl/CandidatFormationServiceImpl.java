package com.ant.formation.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.CandidatFormation;
import com.ant.formation.repositories.CandidatFormationRepository;
import com.ant.formation.services.CandidatFormationService;

@Service
public class CandidatFormationServiceImpl implements CandidatFormationService {

	@Autowired
	private CandidatFormationRepository candidatFormationRepository;

	@Override
	public MessageResponse save(List<CandidatFormation> candidatFormations) {

//		boolean exist = candidatFormationRepository.existsById(candidatFormation.getId());
//		if (exist) {
//			return new MessageResponse(false, "Attention", "CandidatFormation existe déjà");
//		}

		candidatFormationRepository.saveAll(candidatFormations);

		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	public MessageResponse update(CandidatFormation candidatFormation) {
		boolean exist = candidatFormationRepository.existsById(candidatFormation.getId());

		if (exist) {
			return new MessageResponse(false, "Attention", "CandidatFormation existe déjà");

		}

		candidatFormationRepository.save(candidatFormation);

		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	public MessageResponse delete(Integer id) {

		boolean exist = candidatFormationRepository.existsById(id);
		if (exist) {
			return new MessageResponse(false, "Attention", "CandidatFormation affecté a un ou plusieurs planings");
		}

		candidatFormationRepository.deleteById(id);

		return new MessageResponse(true, "Succès", "Opération effectuée");
	}

	@Override
	public List<CandidatFormation> findCandidatByFormation(Integer id) {

		return candidatFormationRepository.findCandidatByFormation(id);
	}

	@Override
	public List<Candidat> findCandidatNotInFormation(Integer id) {
		// TODO Auto-generated method stub
		return candidatFormationRepository.findCandidatNotInFormation(id);
	}

}
