package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Etudiant;
import com.example.abid_mehdi_4twin7.repositories.IEtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantServices implements IEtudiantServices {

    final
    IEtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> ajouterEtudiant(List<Etudiant> etudiants) {
        return etudiantRepository.saveAll(etudiants);
    }


    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        // Implement the update logic here
        return null; // You need to implement this method properly
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
        // Implement the delete logic here
    }

    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        // Implement the get logic here
        return null; // You need to implement this method properly
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        // Implement the logic to get all students here
        return null; // You need to implement this method properly
    }
}
