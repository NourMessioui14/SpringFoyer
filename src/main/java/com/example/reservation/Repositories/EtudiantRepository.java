package com.example.reservation.Repositories;

import com.example.reservation.Entities.Etudiant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EtudiantRepository extends CrudRepository<Etudiant,Long> {
    Optional<Etudiant> findByCin(long cin);

}
