package com.example.abid_mehdi_4twin7.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    private TypeChambre typeC;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
