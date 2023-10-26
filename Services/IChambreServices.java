package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Chambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> getAllChambre();

    Chambre updateChambre (Chambre c);

    Chambre ajouterChambre (Chambre c);

    Chambre getChambre (long idChambre);

}
