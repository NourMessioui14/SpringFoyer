package com.example.reservation.Controllers;

import com.example.reservation.Entities.Bloc;
import com.example.reservation.Repositories.BlocRepository;
import com.example.reservation.Services.IBlocService;
import io.swagger.v3.oas.annotations.media.PatternProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("bloc")
@Slf4j
public class BlocController {
    private final IBlocService iBlocService;
    @GetMapping
    public List<Bloc> getAll(){
        return (List<Bloc>) iBlocService.getAll();

    }
    @GetMapping("{id}")
    public Bloc getById(@PathVariable long id){
        return iBlocService.getById(id);
    }
    @PostMapping
    public Bloc addBloc(@RequestBody Bloc b){
        return iBlocService.addBloc(b);
    }
    @PutMapping
    public  Bloc update(@RequestBody Bloc b){
        return iBlocService.update(b);
    }
    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable long id){
        iBlocService.deleteById(id);
        return !(iBlocService.deleteById(id));
    }

    @PostMapping("/{idBloc}/affecterChambres")
    public ResponseEntity<Bloc> affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        try {
            Bloc bloc = iBlocService.affecterChambresABloc(numChambre, idBloc);
            return ResponseEntity.ok(bloc);
        } catch (Exception e) {
            // Handle the exception appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("{date}")
    public void dateTest(@PathVariable LocalDate date){
        log.info(String.valueOf(date));
    }
}
