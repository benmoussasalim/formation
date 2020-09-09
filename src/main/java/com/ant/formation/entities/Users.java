package com.ant.formation.entities;

import com.ant.formation.enums.Role;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Users extends Personne {
    private String username;
    private String password;
    private boolean enabled;
   @Enumerated(EnumType.STRING)
    private Role role;
   @OneToMany(mappedBy = "user")
   private List<Paiment> paiments;
}
