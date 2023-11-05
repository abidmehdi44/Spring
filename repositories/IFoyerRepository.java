package com.example.abid_mehdi_4twin7.repositories;

import com.example.abid_mehdi_4twin7.entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByNomFoyer(String nomF);
}
