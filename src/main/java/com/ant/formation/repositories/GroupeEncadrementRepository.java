package com.ant.formation.repositories;

import com.ant.formation.entities.GroupeEncadrement;
import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeEncadrementRepository extends
        JpaRepository<GroupeEncadrement, Integer> {
}
