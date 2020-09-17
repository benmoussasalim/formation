package com.ant.formation;

import com.ant.formation.entities.Salle;
import com.ant.formation.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication

@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
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
