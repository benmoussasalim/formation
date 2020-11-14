package com.ant.formation.repositories;

import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.FormateurTheme;
import com.ant.formation.entities.FormateurThemeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormateurThemeRepository extends JpaRepository<FormateurTheme, FormateurThemeId> {


    void deleteByFormateur(Formateur formateur);
}
