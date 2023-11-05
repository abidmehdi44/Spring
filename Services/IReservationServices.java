package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationServices {

    List<Reservation> getAllReservation();

    Reservation updateReservation (Reservation r);

    Reservation getReservation (String idReservation);

    Reservation ajouterReservation(Reservation r);

    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant (Reservation res, Long numChambre, long cin);

    long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee);

}
