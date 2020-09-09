package com.ant.formation.repositories;

import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateursRepository extends JpaRepository<Formateur, Integer> {
}
