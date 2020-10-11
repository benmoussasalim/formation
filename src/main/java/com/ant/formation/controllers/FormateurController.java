package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.services.FormateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/formateur")
public class FormateurController {
    @Autowired
    private FormateurService formateurService;
    @GetMapping
    public List<Formateur> findAll() {
        return  formateurService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Formateur formateur) {
        return  formateurService.save(formateur);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Formateur formateur) {
        return  formateurService.update(formateur);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return  formateurService.delete(id);
    }
    @GetMapping("/{id}")
    public Formateur findById(@PathVariable Integer id)
    {
        return formateurService.findByID(id);
    }
}
