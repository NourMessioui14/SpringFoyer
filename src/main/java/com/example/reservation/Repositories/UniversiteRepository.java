package com.example.reservation.Repositories;

import com.example.reservation.Entities.Universite;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UniversiteRepository extends CrudRepository<Universite,Long> {
    Optional<Universite> findByNomUniversite(String nomUniversite);

}
