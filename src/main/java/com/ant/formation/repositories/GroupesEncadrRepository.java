package com.ant.formation.repositories;

import com.ant.formation.entities.GroupeEncadrement;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupesEncadrRepository extends JpaRepository<GroupeEncadrement, Integer> {
}
