package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.CandidatFormation;
import com.ant.formation.services.CandidatFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/candidatFormation")
@CrossOrigin("*")
public class CandidatFormationController {

    @Autowired
    private CandidatFormationService candidatFormationService;

    @GetMapping
    public List<CandidatFormation> findAll() {
        return  candidatFormationService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody CandidatFormation candidatFormation) {
        return  candidatFormationService.save(candidatFormation);
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
