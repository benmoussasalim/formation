package com.ant.formation.entities;

import com.ant.formation.enums.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Users extends Personne {
    private String username;
    private String password;
   /* @Enumerated(EnumType.STRING)
    private Role role;*/
}
