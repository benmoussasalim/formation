package com.ant.formation.repositories;

import com.ant.formation.entities.Theme;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemesRepository extends JpaRepository<Theme, Integer> {
}
