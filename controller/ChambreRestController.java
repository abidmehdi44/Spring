package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IChambreServices;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Bloc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("chambre")
public class ChambreRestController {
    private final IChambreServices chambreServices;

    @GetMapping("/allchambre")
    public List<Chambre> getAllChambre() {
        return chambreServices.getAllChambre();
    }

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreServices.ajouterChambre(c);
    }

    @PutMapping("/update/{idChambre}")
    public Chambre updateChambre(@PathVariable Long idChambre, @RequestBody Chambre updatedChambre) {
        Chambre existingChambre = chambreServices.getChambre(idChambre);

        if (existingChambre != null) {
            // Mettez à jour les attributs de la chambre existante avec les nouvelles valeurs
            existingChambre.setNumeroChambre(updatedChambre.getNumeroChambre());
            existingChambre.setTypeC(updatedChambre.getTypeC());
            existingChambre.setBloc(updatedChambre.getBloc());
            existingChambre.setReservations(updatedChambre.getReservations());

            // Enregistrez la chambre mise à jour
            return chambreServices.updateChambre(existingChambre);
        } else {
            return null;
        }
    }
}