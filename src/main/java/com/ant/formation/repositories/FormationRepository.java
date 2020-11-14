package com.ant.formation.repositories;

import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Formation;
import com.ant.formation.entities.Theme;
import com.ant.formation.enums.StatusFormation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
    boolean existsByIdAndCandidatFormationsIsNotNullOrPlaningsIsNotNull(Integer id);
    List<Formation> findByStatusFormation(StatusFormation status);


}
