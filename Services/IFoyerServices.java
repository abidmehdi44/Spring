package com.example.abid_mehdi_4twin7.Services;
import com.example.abid_mehdi_4twin7.entities.Foyer;

import java.util.List;

public interface IFoyerServices {
    Foyer ajouterFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    void supprimerFoyer(long idFoyer);
    Foyer getFoyer(long idFoyer);
    List<Foyer> getAllFoyer();
    public Foyer ajouterFoyeretAffecterUniv(Foyer f,Long idUniv);

}
