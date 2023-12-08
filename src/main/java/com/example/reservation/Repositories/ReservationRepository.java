package com.example.reservation.Repositories;

import com.example.reservation.Entities.Etudiant;
import com.example.reservation.Entities.Reservation;
import org.hibernate.mapping.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,String> {
    Reservation findByIdReservation(String idReservation);

    Reservation findReservationsByAnneeUniversitaire(Date date);
    boolean existsByEtudiantsCinAndAnneeUniversitaireBetween(long etudiants_cin, LocalDate startDate, LocalDate finDate);

    @Query("select Reservation from Reservation r join Chambre c where c.blocs.foyers.universite.nomUniversite=:nomUniversite and r.anneeUniversitaire=:anneeUniversitaire")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@Param("anneeUniversitaire") Date anneeUniversite, @Param("nomUniversite") String nomUniversite) ;



}
