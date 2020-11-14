package com.ant.formation.services;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Formation;
import com.ant.formation.entities.Theme;
import com.ant.formation.enums.StatusFormation;

import java.util.List;

public interface FormationService {
	public MessageResponse save(Formation formation);

	public MessageResponse update(Formation formation);

	public MessageResponse delete(Integer id);

	public List<Formation> findByStatus(StatusFormation statusFormation);

	public Formation findById(Integer id);

}
