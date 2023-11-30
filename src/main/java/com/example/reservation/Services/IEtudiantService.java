package com.example.reservation.Services;

import com.example.reservation.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    Etudiant addEtudiant(Etudiant e);
    Etudiant update(Etudiant e);
    List<Etudiant> getAll();
    Etudiant getById(long id);
    boolean deleteById(long id);
}
