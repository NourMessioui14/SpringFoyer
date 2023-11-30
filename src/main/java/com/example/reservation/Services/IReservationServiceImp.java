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
        LocalDate startDate =  LocalDate.of(LocalDate.now().getYear()
                ,LocalDate.now().getMonth()
                ,LocalDate.now().getDayOfMonth());


        LocalDate finDate =  LocalDate.of(LocalDate.now().getYear()
                ,LocalDate.now().getMonth()
                ,LocalDate.now().getDayOfMonth());



        Assert.isTrue(reservationRepository.existsByEtudiantsCinAndAnneeUniversitaireBetween(cinEtudiant,startDate,finDate),"you have a reservation");

        Chambre chambre = chambreRepository.findById(idChambre)
                .orElseThrow(() -> new ChambreNotFoundException("universite not found"));
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant)
                .orElseThrow(()-> new EtudiantNotFoundException("etudiant not found"));
        String id = chambre.getNumeroChambre()+"-"+chambre.getBlocs().getNomBloc()+"-"+ LocalDate.now().getYear();
        Reservation reservation = reservationRepository.findById(id).orElse(
                Reservation.builder().
                        idReservation(id)
                        .anneeUniversitaire(LocalDate.now())
                        .estValide(true)
                        .etudiants(new ArrayList<Etudiant>()).build()

                );
        Assert.isTrue(reservation.isEstValide(),"room not valid");
        reservation.getEtudiants().add(etudiant);

        if(!chambre.getReservations().contains(reservation)){
            reservationRepository.save(reservation);
            chambre.getReservations().add(reservation);
        }
        switch (chambre.getTypeChambre()){
            case SIMPLE -> reservation.setEstValide(false);
            case DOUBLE -> {
                if (reservation.getEtudiants().size()==2){
                reservation.setEstValide(false); }
                            }
            case TRIPLE -> {
                if (reservation.getEtudiants().size()==3){
                    reservation.setEstValide(false); }
                            }
        }

        return reservation;

    }

    @Override
    public Reservation getReservationParAnneeUniversitaire(Date date) {
        return  reservationRepository.findReservationsByAnneeUniversitaire(date);
    }



}
