package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.entities.Theme;
import com.ant.formation.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/theme")
@CrossOrigin("*")
public class ThemeController {
    @Autowired
    private ThemeService themeService;
    @GetMapping
    public List<Theme> findAll() {
        return  themeService.findAll();
    }
    
    @GetMapping("/formateur/{id}")
    public List<Theme> findByFormateur(@PathVariable Integer id) {
		return themeService.findByFormateur(id);
    }

    @PostMapping
    public MessageResponse save(@RequestBody Theme theme) {
        return  themeService.save(theme);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Theme theme) {
        return  themeService.update(theme);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return  themeService.delete(id);
    }
}
