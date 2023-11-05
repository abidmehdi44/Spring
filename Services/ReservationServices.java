package com.example.abid_mehdi_4twin7.Services;

import com.example.abid_mehdi_4twin7.entities.Bloc;
import com.example.abid_mehdi_4twin7.entities.Chambre;
import com.example.abid_mehdi_4twin7.entities.Etudiant;
import com.example.abid_mehdi_4twin7.entities.Reservation;
import com.example.abid_mehdi_4twin7.repositories.IChamberRepository;
import com.example.abid_mehdi_4twin7.repositories.IEtudiantRepository;
import com.example.abid_mehdi_4twin7.repositories.IReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationServices implements IReservationServices {

    final
    IReservationRepository reservationRepository;
    final
    IChamberRepository chamberRepository;
    final
    IEtudiantRepository etudiantRepository;

    @Override
    public Reservation updateReservation (Reservation r)
    {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation getReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation ajouterReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    @Transactional
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, long cin) {
        this.ajouterReservation(res);
        Chambre ch = chamberRepository.findByNumeroChambre(numChambre);
        Etudiant et = etudiantRepository.findEtudiantByCin(cin);
        ch.getReservations().add(res);
        et.getReservations().add(res);
        return res;
    }

    @Override
    public long getReservationParAnneeUniversitaire(Date debutAnnee, Date finAnnee) {
        return  reservationRepository.findByDateReservationBetween(debutAnnee,finAnnee).size();

    }


}
