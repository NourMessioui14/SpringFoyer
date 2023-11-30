package com.example.reservation.Services;

import com.example.reservation.Entities.Reservation;


import java.sql.Date;
import java.util.List;

public interface IReservationService {
    Reservation addReservation (Reservation r);
    Reservation update(Reservation r,String id);
    List<Reservation> getAll();
    Reservation getById(String id);
    boolean deleteById(String id);
    Reservation ajouterReservation(long idChambre, long cinEtudiant);
    public Reservation getReservationParAnneeUniversitaire(Date date );


}
