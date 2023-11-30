package com.example.reservation.Services;

import com.example.reservation.Entities.Bloc;
import com.example.reservation.Entities.Foyer;
import com.example.reservation.Entities.Universite;
import com.example.reservation.Exception.FoyerNotFoundException;
import com.example.reservation.Repositories.FoyerRepository;
import com.example.reservation.Repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class IFoyerServiceImp implements IFoyerService{
   private final FoyerRepository foyerRepository;
   private final UniversiteRepository universiteRepository;
    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> getAll() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer getById(long id) {
        return foyerRepository.findById(id).orElseThrow(() -> new FoyerNotFoundException("no foyer found"+id));
    }

    @Override
    public boolean deleteById(long id) {
        foyerRepository.deleteById(id);
        return !(foyerRepository.existsById(id));
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new FoyerNotFoundException("Universite not found"));

        // Set the Universite to the Foyer
        foyer.setUniversite(universite);

        // Also set the Foyer to the Universite
        universite.setFoyers(foyer);

        // Set the Foyer to each Bloc, if present
        if (foyer.getBlocs() != null) {
            foyer.getBlocs().forEach(bloc -> bloc.setFoyers(foyer));
        }

        // Save the Foyer and Universite
        Foyer savedFoyer = foyerRepository.save(foyer);
        universiteRepository.save(universite);

        return savedFoyer;

    }


}
