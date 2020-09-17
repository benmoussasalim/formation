package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Candidat;
import com.ant.formation.entities.Formateur;
import com.ant.formation.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidat")
public class CandidatController {
    @Autowired
    private CandidatService candidatService;

    @GetMapping
    public List<Candidat> findAll() {
        return  candidatService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Candidat candidat) {
        return  candidatService.save(candidat);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Candidat candidat) {
        return  candidatService.update(candidat);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return candidatService.delete(id);
    }
    @GetMapping("/{id}")
    public Candidat findById(@PathVariable Integer id)
    {
        return candidatService.findByID(id);
    }
}
