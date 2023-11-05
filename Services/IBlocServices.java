package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;

import java.util.List;

public interface IBlocServices {

    List<Bloc> getAllBloc();

    Bloc updateBloc (Bloc b);

    Bloc ajouterBloc (Bloc b);

    Bloc getBloc (long idBloc);

    void supprimerBloc (long idBloc);
    public Bloc affecterChambresABloc (List<Long> numChambre, String nomBloc) ;

}
