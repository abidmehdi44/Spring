package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.TypeChambre;

import java.util.List;

public interface IChambreServices {
    List<Chambre> getAllChambre();

    Chambre updateChambre (Chambre c);

    Chambre ajouterChambre (Chambre c);

    Chambre getChambre (long idChambre);
    List<Chambre> getChambresParNomBloc( String nomBloc);

    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;

    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type);

}
