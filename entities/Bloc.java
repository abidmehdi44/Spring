package com.example.abid_mehdi_4twin7.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;

    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    @OneToMany(mappedBy="bloc",/*fetch = FetchType.EAGER ,*/cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Chambre> chambres;

}
