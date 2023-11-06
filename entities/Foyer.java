package com.example.abid_mehdi_4twin7.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToMany(mappedBy = "foyer", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Bloc> blocs;

    @OneToOne(mappedBy = "f")
    private Universite uni;

}
