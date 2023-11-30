package com.example.reservation.Services;

import com.example.reservation.Entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre c);
    Chambre update(Chambre c);
    List<Chambre> getAll();
    Chambre getById(long id);
    boolean deleteById(long id);
   // boolean isCapacityReached(long idChambre);

    // List<Chambre> getChambresParNomUniversite(String nomUniversite);


}
