package com.example.reservation.Repositories;

import com.example.reservation.Entities.Bloc;
import com.example.reservation.Entities.Foyer;
import com.example.reservation.Entities.Universite;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoyerRepository extends CrudRepository<Foyer,Long> {



}
