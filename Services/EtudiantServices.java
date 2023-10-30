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
        return etudiantRepository.save(e);
    }

    @Override
    public void supprimerEtudiant(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }


    @Override
    public Etudiant getEtudiant(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }
}
