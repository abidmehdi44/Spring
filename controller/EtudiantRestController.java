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
            // Mettez à jour les attributs de l'étudiant existant avec les nouvelles valeurs
            existingEtudiant.setNomEt(updatedEtudiant.getNomEt());
            existingEtudiant.setPrenomEt(updatedEtudiant.getPrenomEt());
            existingEtudiant.setCin(updatedEtudiant.getCin());
            existingEtudiant.setEcole(updatedEtudiant.getEcole());
            existingEtudiant.setDateNaissance(updatedEtudiant.getDateNaissance());

            // Enregistrez l'étudiant mis à jour
            return etudiantServices.updateEtudiant(existingEtudiant);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiant(idEtudiant);
        if (existingEtudiant != null) {
            // Supprimez l'étudiant en utilisant le service
            etudiantServices.supprimerEtudiant(idEtudiant);
        } else {
            log.warn("N'existe pas");
        }
    }
}