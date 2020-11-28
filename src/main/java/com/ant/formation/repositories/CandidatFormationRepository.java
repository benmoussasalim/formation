package com.ant.formation.repositories;

import com.ant.formation.entities.CandidatFormation;
import com.ant.formation.entities.CandidatFormationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatFormationRepository  extends JpaRepository<CandidatFormation, CandidatFormationId> {
    boolean existsById(Integer id);

    void deleteById(Integer id);
}
