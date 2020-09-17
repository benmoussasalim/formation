//package com.ant.formation.controllers;
//
//import com.ant.formation.dto.MessageResponse;
//import com.ant.formation.entities.Formation;
//import com.ant.formation.services.FormationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/formation")
//public class FormationController {
//    @Autowired
//    private FormationService formationService;
//    @GetMapping
//    public List<Formation> findAll() {
//        return  formationService.findAll();
//    }
//
//    @PostMapping
//    public MessageResponse save(@RequestBody Formation formation) {
//        return  formationService.save(formation);
//    }
//
//    @PutMapping
//    public MessageResponse update(@RequestBody Formation formation) {
//        return  formationService.update(formation);
//    }
//
//    @DeleteMapping("/{id}")
//    public MessageResponse delete(@PathVariable("id") Integer id) {
//        return  formationService.delete(id);
//    }
//}
