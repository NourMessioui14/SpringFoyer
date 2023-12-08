package com.example.reservation.Repositories;

import com.example.reservation.Entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
