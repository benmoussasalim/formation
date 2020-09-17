package com.ant.formation.repositories;

import com.ant.formation.entities.Salle;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleRepository extends JpaRepository<Salle, Integer> {
    boolean existsByLibelle(String libelle);
    boolean existsByIdAndPlaningsIsNotNull(Integer id);

}
