package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IUniversiteServices;
import com.example.abid_mehdi_4twin7.entities.Universite;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("universite")
public class UniversiteRestController {
    private final IUniversiteServices universiteServices;

    @GetMapping("/alluniversite")
    public List<Universite> getAllUniversite() {
        return universiteServices.getAllUniversite();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteServices.ajouterUniversite(u);
    }

    @PutMapping("/update/{idUniversite}")
    public Universite updateUniversite(@PathVariable Long idUniversite, @RequestBody Universite updatedUniversite) {
        Universite existingUniversite = universiteServices.getUniversite(idUniversite);

        if (existingUniversite != null) {
            // Mettez à jour les attributs de l'université existante avec les nouvelles valeurs
            existingUniversite.setNomUniversite(updatedUniversite.getNomUniversite());
            existingUniversite.setAdresse(updatedUniversite.getAdresse());

            // Enregistrez l'université mise à jour
            return universiteServices.updateUniversite(existingUniversite);
        } else {
            return null;
        }
    }

    @PutMapping("/AffecterUnivFoyer/{id_Foyer}/{nomUniv}")
    public Universite affecterUnivFoyer(@PathVariable long id_Foyer, @PathVariable String nomUniv) {
        return  universiteServices.affecterFoyerAUniversite(id_Foyer, nomUniv);
    }

}