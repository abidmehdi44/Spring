package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Universite;
import com.example.abid_mehdi_4twin7.repositories.IUniversiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UniversiteServices implements IUniversiteServices {

    final IUniversiteRepository universiteRepository;

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

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepository.findAll();
    }


}
