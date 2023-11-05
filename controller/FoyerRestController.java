package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IFoyerServices;
import com.example.abid_mehdi_4twin7.entities.Foyer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("foyer")
public class FoyerRestController {
    private final IFoyerServices foyerServices;

    @GetMapping("/allfoyer")
    public List<Foyer> getAllFoyer(){
        return foyerServices.getAllFoyer();
    }


    @GetMapping("/add/{id-foyer}")
        public Foyer getFoyer(@PathVariable("id-foyer") long id){
        return foyerServices.getFoyer(id);
    }


    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.ajouterFoyer(f);
    }

    @PutMapping("/update/{idFoyer}")
    public Foyer updateFoyer(@PathVariable Long idFoyer, @RequestBody Foyer updatedFoyer) {
        Foyer existingFoyer = foyerServices.getFoyer(idFoyer);
        if (existingFoyer != null) {
            existingFoyer.setNomFoyer(updatedFoyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(updatedFoyer.getCapaciteFoyer());
            return foyerServices.updateFoyer(existingFoyer);
        } else {
            return null;
        }
    }
    @DeleteMapping("/delete/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer) {
        Foyer existingFoyer = foyerServices.getFoyer(idFoyer);

        if (existingFoyer != null) {
            foyerServices.supprimerFoyer(idFoyer);
        } else {
            log.warn("N'existe pas");
        }
    }
}