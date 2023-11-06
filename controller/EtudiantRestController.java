package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IEtudiantServices;
import com.example.abid_mehdi_4twin7.entities.Etudiant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("etudiant")

public class EtudiantRestController {
    private final IEtudiantServices etudiantServices;

    @GetMapping("/alletudiant")
    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.getAllEtudiant();
    }


    @PostMapping("/add")
    public List<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        List<Etudiant> etudiants = new ArrayList<>();
        etudiants.add(etudiant);
        return etudiantServices.ajouterEtudiant(etudiants);
    }

    @PutMapping("/update/{idEtudiant}")
    public Etudiant updateEtudiant(@PathVariable Long idEtudiant, @RequestBody Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiant(idEtudiant);

        if (existingEtudiant != null) {
            existingEtudiant.setNomEt(updatedEtudiant.getNomEt());
            existingEtudiant.setPrenomEt(updatedEtudiant.getPrenomEt());
            existingEtudiant.setCin(updatedEtudiant.getCin());
            existingEtudiant.setEcole(updatedEtudiant.getEcole());
            existingEtudiant.setDateNaissance(updatedEtudiant.getDateNaissance());
            return etudiantServices.updateEtudiant(existingEtudiant);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiant(idEtudiant);
        if (existingEtudiant != null) {
            etudiantServices.supprimerEtudiant(idEtudiant);
        } else {
            log.warn("N'existe pas");
        }
    }
}