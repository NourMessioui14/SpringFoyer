package com.example.reservation.Services;

import com.example.reservation.Entities.Etudiant;
import com.example.reservation.Exception.EtudiantNotFoundException;
import com.example.reservation.Repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IEtudiantServiceImp implements IEtudiantService  {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant update(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public List<Etudiant> getAll() {
        return (List<Etudiant>) etudiantRepository.findAll();
    }

    @Override
    public Etudiant getById(long id) {
        return etudiantRepository.findById(id).orElseThrow(() -> new EtudiantNotFoundException("no etudiant found"+id));
    }

    @Override
    public boolean deleteById(long id) {
        etudiantRepository.deleteById(id);
        return !(etudiantRepository.existsById(id));
    }
}
