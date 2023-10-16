package com.example.abid_mehdi_4twin7.entities;


import jakarta.persistence.*;

@Entity
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;

    private String nomUniversite;
    private String adresse;

    @OneToOne
    private Foyer f;

}
