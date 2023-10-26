package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {

    List<Etudiant> ajouterEtudiant(List<Etudiant> etudiants);
    Etudiant updateEtudiant(Etudiant e);
    void supprimerEtudiant(long idEtudiant);
    Etudiant getEtudiant(long idEtudiant);
    List<Etudiant> getAllEtudiant();
}
