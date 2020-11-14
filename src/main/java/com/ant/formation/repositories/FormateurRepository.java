package com.ant.formation.repositories;

import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Theme;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FormateurRepository extends JpaRepository<Formateur, Integer> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndId(String email, Integer id);
    boolean existsByIdAndFormationsIsNotNull(Integer id);


    public List<Formateur> findByFormateurThemes_Theme(Theme theme);
}
