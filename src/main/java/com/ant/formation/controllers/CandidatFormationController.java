package com.ant.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.CandidatFormation;
import com.ant.formation.services.CandidatFormationService;


@RestController
@RequestMapping("/candidatFormation")
@CrossOrigin("*")
public class CandidatFormationController {

    @Autowired
    private CandidatFormationService candidatFormationService;

    @GetMapping("/affected/{idFormation}")
    public List<CandidatFormation> findCandidatByFormation(@PathVariable Integer idFormation) {
        return  candidatFormationService.findCandidatByFormation(idFormation);
    }
    @GetMapping("/notAffected/{idFormation}")
    public List<Candidat> findCandidatNotInFormation(@PathVariable Integer idFormation) {
        return  candidatFormationService.findCandidatNotInFormation(idFormation);
    }
    @PostMapping
    public MessageResponse save(@RequestBody List<CandidatFormation> candidatFormations) {
        return  candidatFormationService.save(candidatFormations);
    }

    @PutMapping
    public MessageResponse update(@RequestBody CandidatFormation candidatFormation) {
        return  candidatFormationService.update(candidatFormation);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return  candidatFormationService.delete(id);
    }
}
