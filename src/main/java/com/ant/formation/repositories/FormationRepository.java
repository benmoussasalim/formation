package com.ant.formation.repositories;

import com.ant.formation.entities.Formation;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {
}
