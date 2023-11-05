package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Foyer;
import com.example.abid_mehdi_4twin7.entities.TypeChambre;
import com.example.abid_mehdi_4twin7.repositories.IChamberRepository;
import com.example.abid_mehdi_4twin7.repositories.IFoyerRepository;
import com.example.abid_mehdi_4twin7.repositories.IblocRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChambreServices implements IChambreServices {

    final
    IChamberRepository chambreRepository;
    final
    IblocRepository iblocRepository;
    final
    IFoyerRepository ifoyerRepository;

    @Override
    public Chambre ajouterChambre (Chambre c)
    {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre (Chambre c)
    {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = iblocRepository.findByNomBloc(nomBloc);
        return new ArrayList<>(b.getChambres());
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = iblocRepository.findById(idBloc).orElse(null);
        int nb=0;
        for(Chambre ch :b.getChambres())
            if(ch.getTypeC()==type) nb++;
        return nb;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {
        Foyer f = ifoyerRepository.findByNomFoyer(nomFoyer);

        List<Chambre> NonResChambreList = new  ArrayList<>();
        f.getBlocs().forEach(bloc -> {
            bloc.getChambres().forEach(chambre -> {
                if (chambre.getTypeC()==type && chambre.getReservations().isEmpty()){
                    NonResChambreList.add(chambre);
                }
            });
        });
        return NonResChambreList;
    }

}
