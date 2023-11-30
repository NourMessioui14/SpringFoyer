package com.example.reservation.Controllers;

import com.example.reservation.Entities.Foyer;
import com.example.reservation.Services.IFoyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("foyer/")
public class FoyerController {
    public final IFoyerService iFoyerService;

    @GetMapping
    public List<Foyer> getAll(){
        return (List<Foyer>) iFoyerService.getAll();
    }
    @GetMapping("{id}")
    public Foyer getById(@PathVariable long id){
        return iFoyerService.getById(id);
    }
    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer f ){
        return iFoyerService.addFoyer(f);
    }
    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.updateFoyer(f);
    }
    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable long id){
        iFoyerService.deleteById(id);
        return !(iFoyerService.deleteById(id));
    }
    @PostMapping("addAndAssignToUniversite/{idUniversite}")
    public ResponseEntity<Foyer> addFoyerAndAssignToUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        try {
            Foyer addedFoyer = iFoyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
            return ResponseEntity.ok(addedFoyer);
        } catch (Exception e) {
            // Handle exception (e.g., Universite not found, invalid data, etc.)
            return ResponseEntity.badRequest().build();
        }
    }

}
