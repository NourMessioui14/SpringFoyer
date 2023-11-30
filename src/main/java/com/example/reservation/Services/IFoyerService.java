package com.example.reservation.Services;

import com.example.reservation.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer f);
    Foyer updateFoyer(Foyer f);
    List<Foyer> getAll();
    Foyer getById(long id);
    boolean deleteById(long id);
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
