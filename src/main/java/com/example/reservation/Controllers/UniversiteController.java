package com.example.reservation.Controllers;

import com.example.reservation.Entities.Universite;
import com.example.reservation.Services.IUniversiteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("universite")
public class UniversiteController {
    public final IUniversiteService iUniversiteService;
    @GetMapping
    public List<Universite> getAll(){
        return iUniversiteService.getAll();
    }
    @GetMapping("id")
    public Universite getById(@PathVariable long id){
        return iUniversiteService.getById(id);
    }
    @PostMapping
    public Universite addUniversite(@RequestBody Universite u){
        return iUniversiteService.addUniversite(u);
    }
    @PutMapping
    public Universite update(@RequestBody Universite u){
        return iUniversiteService.update(u);
    }
    @DeleteMapping("{id}")
    public boolean  deleteById(@PathVariable long id){
        iUniversiteService.deleteById(id);
        return !(iUniversiteService.deleteById(id));

    }
    @PutMapping("/affecter/{id}")
    public ResponseEntity<Universite> affecter(@PathVariable Long id, @RequestParam("nomUniversite") String universite) {
        try {
            Universite updatedUniversite = iUniversiteService.affecterFoyerAUniversite(id, universite);
            return ResponseEntity.ok(updatedUniversite);
        } catch (EntityNotFoundException e) {
            // Handle specific exceptions if needed
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // General exception handling
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{idUniversite}/desaffecterFoyer")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        try {
            Universite universite = iUniversiteService.desaffecterFoyerAUniversite(idUniversite);
            return ResponseEntity.ok(universite);
        } catch (Exception e) {
            // Handle exceptions appropriately
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
