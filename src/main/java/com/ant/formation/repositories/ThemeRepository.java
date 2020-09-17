package com.ant.formation.repositories;

import com.ant.formation.entities.Theme;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    boolean existsByLibelle(String libelle);
    boolean existsByIdAndFormateursIsNotNullOrFormationsIsNotNull(Integer id);
    Theme findByLibelle(String libelle);

}

