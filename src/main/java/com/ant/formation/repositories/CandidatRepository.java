package com.ant.formation.repositories;

import com.ant.formation.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
    boolean existsByCin(String cin);


    boolean existsByEmail(String email);

    boolean existsByCinAndId(String cin, Integer id);

    boolean existsByEmailAndId(String email, Integer id);

    boolean existsByIdAndCandidatFormationsIsNotNullOrGroupeEncadrementsIsNotNull(Integer id);

    List<Candidat> findAllByNomContainsOrPrenomContains(String nom, String prenom);


    @Query("select e from Candidat e where lower(concat(e.nom, ' ', e.prenom )) like lower(concat('%', :search, '%')) " +
            "or lower(concat(e.prenom, ' ', e.nom )) like lower(concat('%', :search, '%'))")
    List<Candidat> findByFirstNameOrLastName(@Param("search") String search);
}
