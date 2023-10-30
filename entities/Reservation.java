package com.example.abid_mehdi_4twin7.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReservation;
    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToMany (mappedBy = "reservations" ,cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;


    public boolean getEstValide(){
        return estValide;
    }

}