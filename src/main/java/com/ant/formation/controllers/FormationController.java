package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Formation;
import com.ant.formation.entities.Theme;
import com.ant.formation.enums.StatusFormation;
import com.ant.formation.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FormationController {
    @Autowired
    private FormationService formationService;
    @GetMapping("/{status}")
    public List<Formation> findByStatus(@PathVariable StatusFormation status) {
        return  formationService.findByStatus(status);
    }

    @PostMapping
    public MessageResponse save(@RequestBody Formation formation) {
        formation.setStatusFormation(StatusFormation.EN_ATTENTE);
        return  formationService.save(formation);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Formation formation) {
        return  formationService.update(formation);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return  formationService.delete(id);
    }

}
