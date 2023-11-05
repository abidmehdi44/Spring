package com.example.abid_mehdi_4twin7.repositories;

import com.example.abid_mehdi_4twin7.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChamberRepository extends JpaRepository<Chambre,Long> {
    Chambre findByNumeroChambre(Long numero);
}
