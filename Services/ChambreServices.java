package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.repositories.IChamberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChambreServices implements IChambreServices {

    final
    IChamberRepository chambreRepository;

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
}
