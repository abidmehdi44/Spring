package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Reservation;
import com.example.abid_mehdi_4twin7.repositories.IReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServices implements IReservationServices {

    final
    IReservationRepository reservationRepository;

    @Override
    public Reservation updateReservation (Reservation b)
    {
        return reservationRepository.save(b);
    }

    @Override
    public Reservation getReservation(long idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }


}
