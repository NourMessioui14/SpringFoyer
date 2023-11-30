package com.example.reservation.Services;

import com.example.reservation.Entities.Bloc;
import com.example.reservation.Entities.Chambre;
import com.example.reservation.Entities.Foyer;
import com.example.reservation.Entities.Universite;
import com.example.reservation.Exception.ChambreNotFoundException;
import com.example.reservation.Repositories.BlocRepository;
import com.example.reservation.Repositories.ChambreRepository;
import com.example.reservation.Repositories.UniversiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class IChambreServiceImp implements IChambreService{

    public final ChambreRepository chambreRepository;
    public final UniversiteRepository universiteRepository;
    public final BlocRepository blocRepository;

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre update(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> getAll() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public Chambre getById(long id) {
        return chambreRepository.findById(id).orElseThrow(() -> new ChambreNotFoundException("no chambre found"+id));
    }

    @Override
    public boolean deleteById(long id) {
        chambreRepository.deleteById(id);
        return !(chambreRepository.existsById(id));
    }

   // @Override
    //public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
      //  Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
       //         .orElseThrow(() -> new EntityNotFoundException("Universite not found"));

        //List<Chambre> chambres = new ArrayList<>();
        //for (Foyer foyer : universite.getFoyers()) { // Assuming Universite has a collection of Foyers
         //   for (Bloc bloc : foyer.getBlocs()) { // Assuming Foyer has a collection of Blocs
           //     chambres.addAll(bloc.getChambres()); // Assuming Bloc has a collection of Chambres
            // }
        // }

        //return chambres;
    // }
}
