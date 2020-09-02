package com.ant.formation.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Formateur extends Personne {

    @OneToMany(mappedBy = "formateur")
    private List<Formation> formations;
}
