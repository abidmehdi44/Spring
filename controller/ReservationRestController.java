package com.example.abid_mehdi_4twin7.controller;

import com.example.abid_mehdi_4twin7.Services.IReservationServices;
import com.example.abid_mehdi_4twin7.entities.Reservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
            existingReservation.setDateReservation(updatedReservation.getDateReservation());
            existingReservation.setEstValide(updatedReservation.getEstValide());
            existingReservation.setEtudiants(updatedReservation.getEtudiants());
            return reservationServices.updateReservation(existingReservation);
        } else {
            return null;
        }
    }
    @PutMapping("/ajouterReservationEtAssignerAChambreEtAEtudiant/{numChambre}/{cin}")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiantAPI (@RequestBody Reservation res,@PathVariable Long numChambre,@PathVariable long cin){
        return reservationServices.ajouterReservationEtAssignerAChambreEtAEtudiant(res,numChambre,cin);
    }
    @GetMapping("/getReservationParAnneeUniversitaire/{debutAnnee}/{finAnnee}")
    public long getReservationParAnneeUniversitaireApi(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debutAnnee, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date finAnnee ){
        return reservationServices.getReservationParAnneeUniversitaire(debutAnnee,finAnnee);
    }
}