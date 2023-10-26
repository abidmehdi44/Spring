package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.repositories.IblocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlocServices implements IBlocServices {

    final
    IblocRepository blocRepository;

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

}

