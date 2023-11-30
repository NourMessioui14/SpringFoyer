package com.example.reservation.Services;

import com.example.reservation.Entities.Foyer;
import com.example.reservation.Entities.Universite;
import com.example.reservation.Exception.UniversiteNotFoundException;
import com.example.reservation.Repositories.FoyerRepository;
import com.example.reservation.Repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IUniversiteServiceImp implements IUniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite update(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public List<Universite> getAll() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite getById(long id) {
        return universiteRepository.findById(id).orElseThrow(() -> new UniversiteNotFoundException("no universite found"+id));
    }

    @Override
    public boolean deleteById(long id) {
        universiteRepository.deleteById(id);
        return !(universiteRepository.existsById(id));
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Optional<Universite> optionalUniversite = universiteRepository.findByNomUniversite(nomUniversite);

        if (!optionalUniversite.isPresent()) {
            // Handle the case where the Universite is not found
            throw new UniversiteNotFoundException("Universite not found with name: " + nomUniversite);
        }

        Universite u = optionalUniversite.get();

        Optional<Foyer> optionalFoyer = foyerRepository.findById(idFoyer);
        if (!optionalFoyer.isPresent()) {
            // Handle the case where the Foyer is not found
            throw new UniversiteNotFoundException("Foyer not found with ID: " + idFoyer);
        }

        u.setFoyers(optionalFoyer.get());

        return universiteRepository.save(u);
    }


    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
// Find the Universite
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new UniversiteNotFoundException("Universite not found"));

        // Remove the association with the Foyer
        if (universite.getFoyers() != null) {
            universite.setFoyers(null);
        }

        // Save the updated Universite
        return universiteRepository.save(universite);    }
}
