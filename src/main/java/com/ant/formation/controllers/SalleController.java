package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Salle;
import com.ant.formation.services.SalleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.List;


@RestController
@RequestMapping("/salle")
@CrossOrigin("*")
public class SalleController {

    @Autowired
    private SalleService salleService;

    @GetMapping
    public List<Salle> findAll() {
        return  salleService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Salle salle) {
        return  salleService.save(salle);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Salle salle) {
        return  salleService.update(salle);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return  salleService.delete(id);
    }
}
