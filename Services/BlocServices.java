package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Foyer;
import com.example.abid_mehdi_4twin7.repositories.IChamberRepository;
import com.example.abid_mehdi_4twin7.repositories.IFoyerRepository;
import com.example.abid_mehdi_4twin7.repositories.IblocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlocServices implements IBlocServices {

    final
    IblocRepository blocRepository;
    final
    IChamberRepository chamberRepository;
    final
    IFoyerRepository foyerRepository;

    @Override
    public Bloc ajouterBloc (Bloc b)
    {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc (Bloc b)
    {
        return blocRepository.save(b);
    }

    @Override
    public void supprimerBloc(long idBloc){
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBloc() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        for(Long id:numChambre){
            Chambre chambre = chamberRepository.findById(id).orElse(null);
            chambre.setBloc(bloc);
        }
        return bloc;
    }

    @Override
    @Transactional
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        Foyer f = foyerRepository.findByNomFoyer(nomFoyer);

        if(b!=null && f!=null){
            b.setFoyer(f);
            return b;
        }
        return  null;

    }

}

