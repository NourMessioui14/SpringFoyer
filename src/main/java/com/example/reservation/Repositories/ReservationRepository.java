package com.example.reservation.Repositories;

import com.example.reservation.Entities.Etudiant;
import com.example.reservation.Entities.Reservation;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation,String> {
    Reservation findReservationsByAnneeUniversitaire(Date date);
    boolean existsByEtudiantsCinAndAnneeUniversitaireBetween(long etudiants_cin, LocalDate startDate, LocalDate finDate);

            //fetch type eagle w lazy



}
