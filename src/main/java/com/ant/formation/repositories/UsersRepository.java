package com.ant.formation.repositories;

import com.ant.formation.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsernameAndId(String username, Integer id);

    boolean existsByEmailAndId(String email, Integer id);

    boolean existsByIdAndPaimentsNotNull(Integer id);
}
