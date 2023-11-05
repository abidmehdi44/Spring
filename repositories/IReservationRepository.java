package com.example.abid_mehdi_4twin7.repositories;

import com.example.abid_mehdi_4twin7.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IReservationRepository extends JpaRepository<Reservation,String> {
    List<Reservation> findByDateReservationBetween(Date dateDebut, Date dateFin);
}
