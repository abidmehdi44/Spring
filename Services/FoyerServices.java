package com.example.abid_mehdi_4twin7.Services;


import com.example.abid_mehdi_4twin7.entities.Foyer;
import com.example.abid_mehdi_4twin7.repositories.IFoyerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final lezm tkoun mawjouda !! (kn sta3malna @Allargs najmou nahiw el final)
@Service
public class FoyerServices implements IFoyerServices {

    final
    IFoyerRepository foyerRepository;


    /*public FoyerServices(IFoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }*/

    @Override
    public Foyer ajouterFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public void supprimerFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return (List<Foyer>) foyerRepository.findAll();
    }
}
