package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Universite;

import java.util.List;

public interface IUniversiteServices {

    List<Universite> getAllUniversite();

    Universite ajouterUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite getUniversite (long idUniversite);

    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite);
    Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite);

}
