package com.ant.formation.repositories;

import com.ant.formation.entities.Planing;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaningsRepository extends JpaRepository<Planing, Integer> {
}
