package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Foyer;
import com.example.abid_mehdi_4twin7.entities.Universite;
import com.example.abid_mehdi_4twin7.repositories.IFoyerRepository;
import com.example.abid_mehdi_4twin7.repositories.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UniversiteServices implements IUniversiteServices {

    final
    IUniversiteRepository universiteRepository;
    final
    IFoyerRepository foyerRepository;

    @Override
    public Universite ajouterUniversite (Universite u)
    {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite (Universite u)
    {
        return universiteRepository.save(u);
    }


    @Override
    public Universite getUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Transactional //kn nzidou hethy nbadlou el return madch save twaly traja3 el object toul
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        universite.setF(foyer);
        //return universiteRepository.save(universite);
        return universite;
    }

    @Override
    @Transactional
    public Universite desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Universite u = universiteRepository.findById(idUniversite).orElse(null);

        if(u!=null && u.getF().getIdFoyer()==idFoyer )
            u.setF(null);
        return u;
    }

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepository.findAll();
    }

}
