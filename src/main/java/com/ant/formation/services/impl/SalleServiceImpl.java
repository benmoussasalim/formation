package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Salle;
import com.ant.formation.repositories.SalleRepository;
import com.ant.formation.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalleServiceImpl implements SalleService {

     @Autowired
     private SalleRepository salleRepository;

    @Override
    public MessageResponse save(Salle salle) {

        boolean exist = salleRepository.existsByLibelle(salle.getLibelle());
        if(exist){
            return  new MessageResponse(false, "Attention", "Salle existe déjà");
        }

        salleRepository.save(salle);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Salle salle) {
    boolean exist = salleRepository.existsByLibelle(salle.getLibelle());

        if(exist){
            return  new MessageResponse(false, "Attention", "Salle existe déjà");

    }




        salleRepository.save(salle);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(Integer id) {


            boolean exist = salleRepository.existsByIdAndPlaningsIsNotNull(id);
            if(exist){
                return  new MessageResponse(false, "Attention",
                        "Salle affecté a un ou plusieurs planings");
            }


        salleRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Salle> findAll() {
        return salleRepository.findAll();
    }


}
