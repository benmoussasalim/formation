package com.ant.formation.services.impl;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Candidat;
import com.ant.formation.repositories.CandidatRepository;
import com.ant.formation.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidatServiceImpl implements CandidatService {

     @Autowired
     private CandidatRepository candidatRepository;

    @Override
    public MessageResponse save(Candidat candidat) {

        boolean exist = candidatRepository.existsByCin(candidat.getCin());
        if(exist){
            return  new MessageResponse(false, "Attention", "CIN existe déjà");
        }
        exist = candidatRepository.existsByEmail(candidat.getEmail());
        if(exist){
            return  new MessageResponse(false, "Attention", "Email existe déjà");
        }


        candidatRepository.save(candidat);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse update(Candidat candidat) {
    boolean exist = candidatRepository.existsByCinAndId(candidat.getCin(), candidat.getId());
    if(!exist) {
        exist = candidatRepository.existsByCin(candidat.getCin());
        if(exist){
            return  new MessageResponse(false, "Attention", "CIN existe déjà");
        }
    }



        exist = candidatRepository.existsByEmailAndId(candidat.getEmail(), candidat.getId());
        if(!exist) {
            exist = candidatRepository.existsByEmail(candidat.getEmail());
            if(exist){
                return  new MessageResponse(false, "Attention", "Email existe déjà");
            }
        }


        candidatRepository.save(candidat);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public MessageResponse delete(Integer id) {


            boolean exist = candidatRepository.existsByIdAndCandidatFormationsIsNotNullOrGroupeEncadrementsIsNotNull(id);
            if(exist){
                return  new MessageResponse(false, "Attention",
                        "Candidat affecté a un ou plusieurs formations");
            }


        candidatRepository.deleteById(id);

        return new MessageResponse(true, "Succès", "Opération effectuée");
    }

    @Override
    public List<Candidat> findAll() {
        return candidatRepository.findAll();
    }

    @Override
    public Candidat findByID(Integer id) {
        return candidatRepository.findById(id).orElse(null);
    }
}
