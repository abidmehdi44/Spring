package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Reservation;

import java.util.List;

public interface IReservationServices {

    List<Reservation> getAllReservation();

    Reservation updateReservation (Reservation r);

    Reservation getReservation (String idReservation);

}
