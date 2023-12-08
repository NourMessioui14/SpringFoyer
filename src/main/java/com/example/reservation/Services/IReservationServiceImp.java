package com.example.reservation.Services;

import com.example.reservation.Entities.Chambre;
import com.example.reservation.Entities.Etudiant;
import com.example.reservation.Entities.Reservation;
import com.example.reservation.Exception.ChambreNotFoundException;
import com.example.reservation.Exception.EtudiantNotFoundException;
import com.example.reservation.Exception.ReservationNotFoundException;
import com.example.reservation.Exception.UniversiteNotFoundException;
import com.example.reservation.Repositories.ChambreRepository;
import com.example.reservation.Repositories.EtudiantRepository;
import com.example.reservation.Repositories.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class IReservationServiceImp implements IReservationService{

    public final ReservationRepository reservationRepository;
    public final ChambreRepository chambreRepository;
    public final EtudiantRepository etudiantRepository;

    @Override
    public Reservation addReservation(Reservation r) {
        return reservationRepository.save(r);
    }

    @Override
    public Reservation update(Reservation updateReservation,String id) {
        Reservation existingReservation = reservationRepository.findById(id)
                .orElseThrow(()-> new ReservationNotFoundException("reservation not found" +id));

        existingReservation.setAnneeUniversitaire(updateReservation.getAnneeUniversitaire());
        existingReservation.setEstValide(updateReservation.isEstValide());

        return reservationRepository.save(existingReservation);
    }

    @Override
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Reservation getById(String id) {
        return reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("no reservation found "+id));
    }

    @Override
    public boolean deleteById(String id) {
        reservationRepository.deleteById(id);
        return !(reservationRepository.existsById(id));
    }

    @Override
    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {

        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new ChambreNotFoundException("universite not found"));
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);
        String id = chambre.getNumeroChambre() + "-" + chambre.getBlocs().getNomBloc() + "-" + LocalDate.now().getYear();
        Reservation reservation = new Reservation();
        reservation.setIdReservation(id);

        reservation.setChambre(chambre);
        reservation.setEstValide(true);
        reservation.setAnneeUniversitaire(LocalDate.now());
//        reservation.getEtudiants().add(etudiant);
        List<Etudiant> lsAux = new ArrayList<Etudiant>();
        lsAux.add(etudiant);
        reservation.setEtudiants(lsAux);

        int maxCapacity;
        switch (chambre.getTypeChambre()) {
            case SIMPLE:
                maxCapacity = 1;
                break;
            case DOUBLE:
                maxCapacity = 2;
                break;
            case TRIPLE:
                maxCapacity = 3;
                break;
            default:
                throw new IllegalArgumentException("Unknown TypeChambre");
        }
        int currentReservations = chambre.getReservations().size();
        if (currentReservations < maxCapacity) {
            reservationRepository.save(reservation);
        }
        return reservation;
    }


    @Override
    public Reservation getReservationParAnneeUniversitaire(Date date) {
        return  reservationRepository.findReservationsByAnneeUniversitaire(date);
    }



}
