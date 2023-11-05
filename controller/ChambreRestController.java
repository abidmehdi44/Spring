package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IChambreServices;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.TypeChambre;
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
            existingChambre.setNumeroChambre(updatedChambre.getNumeroChambre());
            existingChambre.setTypeC(updatedChambre.getTypeC());
            existingChambre.setBloc(updatedChambre.getBloc());
            existingChambre.setReservations(updatedChambre.getReservations());
            return chambreServices.updateChambre(existingChambre);
        } else {
            return null;
        }
    }
    @GetMapping ("/getChambresParNomBloc/{nomBloc}")
    public List<Chambre> getChambresParNomBlocApi(@PathVariable String nomBloc){
        return chambreServices.getChambresParNomBloc(nomBloc);
    }
    @GetMapping ("/getChambresParNomBloc/{type}/{idBloc}")
    public long nbChambreParTypeEtBloc(@PathVariable TypeChambre type, @PathVariable long idBloc){
        return chambreServices.nbChambreParTypeEtBloc(type,idBloc);
    }
    @GetMapping ("/getChambresNonReserveParNomFoyerEtTypeChambre/{nomFoyer}/{type}")
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambreApi(@PathVariable String nomFoyer,@PathVariable TypeChambre type){
        return chambreServices.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer,type);
    }


}