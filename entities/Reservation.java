package com.example.abid_mehdi_4twin7.entities;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany (mappedBy = "reservations" ,cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;

}