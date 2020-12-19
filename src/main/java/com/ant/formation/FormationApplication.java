package com.ant.formation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.ant.formation.entities.CandidatFormation;
import com.ant.formation.repositories.CandidatFormationRepository;


@SpringBootApplication
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class FormationApplication implements CommandLineRunner {
@Autowired
private CandidatFormationRepository candidatFormationRepository;

    public static void main(String[] args) {
        SpringApplication.run(FormationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

     candidatFormationRepository.findCandidatNotInFormation(3);
    	
    	//list.forEach(c-> System.out.println(c));
    }
}
