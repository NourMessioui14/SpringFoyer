package com.example.reservation.Services;

import com.example.reservation.Entities.Bloc;
import com.example.reservation.Entities.Chambre;
import com.example.reservation.Exception.BlocNotFoundException;
import com.example.reservation.Repositories.BlocRepository;
import com.example.reservation.Repositories.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class IBlocServiceImp implements IBlocService{

private final BlocRepository blocRepository;
private final ChambreRepository chambreRepository;

    @Override
    public Bloc addBloc(Bloc b){
        return blocRepository.save(b);
    }
    @Override
    public Bloc update(Bloc b){
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> getAll() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc getById(long id) {
        return blocRepository.findById(id).orElseThrow(()-> new BlocNotFoundException("no bloc found for this id "+id));
    }

    @Override
    public boolean deleteById(long id) {
        blocRepository.deleteById(id);
        return !(blocRepository.existsById(id));
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new BlocNotFoundException("Bloc not found"));

        // Retrieve and assign each Chambre to the Bloc
        numChambre.forEach(chambreId -> {
            Chambre chambre = chambreRepository.findById(chambreId)
                    .orElseThrow(() -> new BlocNotFoundException("Chambre not found"));

            // Assuming there's a method in Chambre to set the Bloc
            chambre.setBlocs(bloc);

            // Optionally save each Chambre if needed
            chambreRepository.save(chambre);
        });

        // Save and return the updated Bloc
        return blocRepository.save(bloc);
    }
    @Override //ajouter l'annotation EnableScheduled
    @Scheduled(fixedRate = 60000)
    public void testSchedulure(){
        log.info("l'etoile dawlaaa ");

    }
    //fixedRate ; cron : chaque minute
    //fixedDeylay : apres execution

}



