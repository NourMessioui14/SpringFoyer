package com.example.reservation.Controllers;

import com.example.reservation.Entities.Etudiant;
import com.example.reservation.Services.IEtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("etudiant")
@CrossOrigin(origins = "http://localhost:4200")

public class EtudiantController {
    public final IEtudiantService iEtudiantService;
    @GetMapping
    public List<Etudiant> getAll(){
        return  (List<Etudiant>) iEtudiantService.getAll();
    }
    @GetMapping("{id}")
    public Etudiant getById(@PathVariable long id){
        return iEtudiantService.getById(id);
    }
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.addEtudiant(e);
    }
    @PutMapping
    public Etudiant update(@RequestBody Etudiant e){
        return iEtudiantService.update(e);
    }
    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable long id){
        iEtudiantService.deleteById(id);
        return !(iEtudiantService.deleteById(id));
    }
}
