package com.ant.formation.controllers;

import com.ant.formation.dto.MessageResponse;
import com.ant.formation.dto.PasswordDto;
import com.ant.formation.entities.Formateur;
import com.ant.formation.entities.Users;
import com.ant.formation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> findAll() {
        return  userService.findAll();
    }

    @PostMapping
    public MessageResponse save(@RequestBody Users user) {
        return  userService.save(user);
    }

    @PutMapping
    public MessageResponse update(@RequestBody Users user) {
        return  userService.update(user);
    }

    @DeleteMapping("/{id}")
    public MessageResponse delete(@PathVariable("id") Integer id) {
        return userService.delete(id);
    }

    @PatchMapping("/password")
    public MessageResponse changePassword (@RequestBody PasswordDto passwordDto)
    {
        return userService.changePassword(passwordDto);
    }
    @PatchMapping("/state/{id}")
    public MessageResponse changeState (@PathVariable Integer id)
    {
        return userService.changeState(id);
    }
    @GetMapping("/{id}")
    public Users findById(@PathVariable Integer id)
    {
        return userService.findByID(id);
    }

}
