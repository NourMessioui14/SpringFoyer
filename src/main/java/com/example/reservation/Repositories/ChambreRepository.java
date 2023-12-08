package com.example.reservation.Repositories;

import com.example.reservation.Entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
   // @Query("SELECT COUNT(r) FROM Reservation r WHERE r.chambre.idChambre = :idChambre")
    // long countReservationsByChambreId(@Param("idChambre") long idChambre);

}
