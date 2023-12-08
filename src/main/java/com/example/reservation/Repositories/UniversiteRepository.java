package com.example.reservation.Repositories;

import com.example.reservation.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Optional<Universite> findByNomUniversite(String nomUniversite);

}
