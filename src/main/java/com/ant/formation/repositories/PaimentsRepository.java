package com.ant.formation.repositories;

import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaimentsRepository extends JpaRepository<Users, Integer> {
}
