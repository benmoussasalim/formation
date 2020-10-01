package com.ant.formation;

import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.Personne;
import com.ant.formation.entities.Salle;
import com.ant.formation.entities.Theme;
import com.ant.formation.repositories.CandidatRepository;
import com.ant.formation.repositories.PersonneRepository;
import com.ant.formation.repositories.SalleRepository;
import com.ant.formation.repositories.ThemeRepository;
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
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private CandidatRepository candidatRepository;
@Autowired
private ThemeRepository themeRepository;

    public static void main(String[] args) {
        SpringApplication.run(FormationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//Salle s1= new Salle();
//s1.setLibelle("Salle 01");
//sallesRepository.save(s1);
//        Theme theme1= new Theme();
//        Theme theme2= new Theme();
     //   Theme theme3= new Theme();
//        theme1.setLibelle("JAVA");
//        theme2.setLibelle("PHP");
   //    theme3.setLibelle("C#");
//        themeRepository.save(theme1);
//        themeRepository.save(theme2);
 //     themeRepository.save(theme3);
//        Salle s2= new Salle();
//        Salle s3= new Salle();
//        Salle s4= new Salle();
//        s2.setLibelle("Salle 02");
//        s3.setLibelle("Salle 03");
//        s4.setLibelle("Salle 04");
//        sallesRepository.save(s2);
//        sallesRepository.save(s3);
//        sallesRepository.save(s4);
  //sallesRepository.deleteAllInBatch();

//        Candidat c1 = new Candidat();
//c1.setNom("salim");
//c1.setPrenom("benmoussa");
//candidatRepository.save(c1);
    }
}
