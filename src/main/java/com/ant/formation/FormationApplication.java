package com.ant.formation;

import com.ant.formation.entities.Salle;
import com.ant.formation.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FormationApplication implements CommandLineRunner {
    @Autowired
    private SalleRepository sallesRepository;


    public static void main(String[] args) {
        SpringApplication.run(FormationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
  //sallesRepository.deleteAllInBatch();
    }
}
