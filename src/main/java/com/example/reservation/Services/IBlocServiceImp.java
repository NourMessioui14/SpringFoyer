package com.example.reservation.Services;

import com.example.reservation.Entities.Bloc;
import com.example.reservation.Entities.Chambre;
import com.example.reservation.Exception.BlocNotFoundException;
import com.example.reservation.Repositories.BlocRepository;
import com.example.reservation.Repositories.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
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
    @Override
    @Transactional
    @Scheduled(fixedRate = 60000)
    public void testSchedulure(){
       List<Bloc> blocs = blocRepository.findAll();
        for (Bloc bloc : blocs) {
           log.info(String.valueOf((bloc.getChambres().size())));
        }
    }





}
    //fixedRate ; cron : chaque minute
    //fixedDeylay : apres execution

    //eagle ki tebda fama One f lekher
    //lazy ki tebda f lekher fama many



//relations : bidirectionnell : medecin child clinique gere la relation fil cliniuqe ma nhotech maped by fil medecin many to many mapped by l'entite medecin li mawjouda fil clinique
//objet f west objet
//les id najem naadi liste des id : 1,2,3 fil methode taayet lel lista.forEach() : ma tnajamch taadi zouz request body
//ki yebda mech id taamel findBy fil repositories
//join member of ki tebda lista
//id patient w id medecin : lezem tasna3 rdv w thot date rdv w tsavih mbaad taffectilou l patient
//





