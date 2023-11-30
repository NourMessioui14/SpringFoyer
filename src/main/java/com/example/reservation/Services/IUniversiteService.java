package com.example.reservation.Services;

import com.example.reservation.Entities.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite u);
    Universite update(Universite u);
    List<Universite> getAll();
    Universite getById(long id);
    boolean deleteById(long id);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite(long idUniversite);


}
