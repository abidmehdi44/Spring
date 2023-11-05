package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IReservationServices;
import com.example.abid_mehdi_4twin7.entities.Reservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationRestController {
    private final IReservationServices reservationServices;

    @GetMapping("/allreservation")
    public List<Reservation> getAllReservation() {
        return reservationServices.getAllReservation();
    }

    @PutMapping("/update/{idReservation}")
    public Reservation updateReservation(@PathVariable String idReservation, @RequestBody Reservation updatedReservation) {
        Reservation existingReservation = reservationServices.getReservation(idReservation);

        if (existingReservation != null) {
            // Mettez à jour les attributs de la réservation existante avec les nouvelles valeurs
            existingReservation.setDateReservation(updatedReservation.getDateReservation());
            existingReservation.setEstValide(updatedReservation.getEstValide());
            existingReservation.setEtudiants(updatedReservation.getEtudiants());

            // Enregistrez la réservation mise à jour
            return reservationServices.updateReservation(existingReservation);
        } else {
            return null;
        }
    }
}