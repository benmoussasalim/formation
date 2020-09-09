package com.ant.formation.repositories;

import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatsRepository extends JpaRepository<Candidat, Integer> {
}
