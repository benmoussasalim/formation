package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Planing;
import com.ant.formation.repositories.PlaningRepository;
import com.ant.formation.services.PlaningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaningServiceImpl implements PlaningService {

     @Autowired
     private PlaningRepository planingRepository;

    @Override
    public MessageResponse save(Planing planing) {


        if(planing.getDateDebut().compareTo(planing.getDateFin())>0){
            return  new MessageResponse(false, "Attention", "Vérifier la date du planing");
        }

        planingRepository.save(planing);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Planing planing) {
   /* boolean exist = planingRepository.existsByLibelle(planing.getLibelle());
    if(!exist) {
        exist = planingRepository.existsByLibelle(planing.getLibelle());
        if(exist){
            return  new MessageResponse(false, "Attention", "Planing existe déjà");
        }
    }




        planingRepository.save(planing);*/

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(String libelle) {


        /*    boolean exist = planingRepository.existsByLibelleAndPlaningsIsNotNull(libelle);
            if(exist){
                return  new MessageResponse(false, "Attention",
                        "Planing affecté a un ou plusieurs planings");
            }


        planingRepository.deleteByLibelle(libelle);*/

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Planing> findAll() {
        return planingRepository.findAll();
    }


}
