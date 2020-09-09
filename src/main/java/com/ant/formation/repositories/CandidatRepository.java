package com.ant.formation.repositories;

import com.ant.formation.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
    boolean existsByCin(String cin);


    boolean existsByEmail(String email);

    boolean existsByCinAndId(String cin, Integer id);

    boolean existsByEmailAndId(String email, Integer id);

    boolean existsByIdAndCandidatFormationsIsNotNullOrGroupeEncadrementsIsNotNull(Integer id);
}
