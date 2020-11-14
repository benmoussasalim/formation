package com.ant.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Integer> {
    boolean existsByLibelle(String libelle);

    Theme findByLibelle(String libelle);

    boolean existsByIdAndFormateurThemesIsNotNullOrFormationsIsNotNull(Integer id);

    public List<Theme> findByFormateurThemes_Formateur(Formateur formateur);

}

