package com.ant.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.CandidatFormation;
import com.ant.formation.entities.CandidatFormationId;

public interface CandidatFormationRepository  extends JpaRepository<CandidatFormation, CandidatFormationId> {
    boolean existsById(Integer id);

    void deleteById(Integer id);
    @Query("select cf from CandidatFormation cf where cf.formation.id=:id")
    List<CandidatFormation>  findCandidatByFormation(Integer id);
    @Query("select cf.candidat from CandidatFormation cf "
    		+ "right join cf.candidat c "
    		+ "where  cf.candidat is Null "
    		+ " OR (cf.formation.id !=:id  "
    		+ "   )")
    List<Candidat>  findCandidatNotInFormation(Integer id);
}
