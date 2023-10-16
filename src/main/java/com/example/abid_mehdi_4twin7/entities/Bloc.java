package com.example.abid_mehdi_4twin7.entities;
import jakarta.persistence.*;

@Entity
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    @JoinColumn(name = "foyer_id") // Specify the foreign key column name
    private Foyer foyer;

}
