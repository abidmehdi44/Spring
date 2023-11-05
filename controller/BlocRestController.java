package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IBlocServices;
import com.example.abid_mehdi_4twin7.entities.Bloc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("bloc")
@Slf4j
public class BlocRestController {
    private final IBlocServices blocServices;

    @GetMapping("/allbloc")
    public List<Bloc> getAllBloc() {
        return blocServices.getAllBloc();
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocServices.ajouterBloc(b);
    }

    @PutMapping("/update/{idBloc}")
    public Bloc updateBloc(@PathVariable Long idBloc, @RequestBody Bloc updatedBloc) {
        Bloc existingBloc = blocServices.getBloc(idBloc);

        if (existingBloc != null) {
            // Mettez à jour les attributs du bloc existant avec les nouvelles valeurs
            existingBloc.setNomBloc(updatedBloc.getNomBloc());
            existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());

            // Enregistrez le bloc mis à jour
            return blocServices.updateBloc(existingBloc);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc) {
        Bloc existingBloc = blocServices.getBloc(idBloc);

        if (existingBloc != null) {
            // Supprimez le bloc en utilisant le service
            blocServices.supprimerBloc(idBloc);
        } else {
            log.warn("N'existe pas");
        }
    }

    @PutMapping("/affecterChambreBloc/{nomBloc}")
    public Bloc affecterChambreBloc(@RequestBody List<Long> numChambre, @PathVariable String nomBloc){
        return blocServices.affecterChambresABloc(numChambre,nomBloc);
    }

    @PutMapping("/affecterBlocAFoyerApi/{nomBloc}/{nomFoyer}")
    public Bloc affecterBlocAFoyer( @PathVariable String nomBloc,@PathVariable String nomFoyer){
        return blocServices.affecterBlocAFoyer(nomBloc,nomFoyer);
    }

}
