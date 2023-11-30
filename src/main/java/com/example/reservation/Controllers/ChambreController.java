package com.example.reservation.Controllers;

import com.example.reservation.Entities.Chambre;
import com.example.reservation.Services.IChambreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("chambre")
public class ChambreController {
    private final IChambreService iChambreService;

    @GetMapping
    public List<Chambre> getAll(){
        return (List<Chambre>) iChambreService.getAll();
    }
    @GetMapping("{id}")
    public Chambre getById(@PathVariable long id){
        return iChambreService.getById(id);
    }
    @PostMapping
    public Chambre addChambre(@RequestBody Chambre c){
        return iChambreService.addChambre(c);
    }
    @PutMapping
    public Chambre update(@RequestBody Chambre c){
        return iChambreService.update(c);
    }
    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable long id){
        iChambreService.deleteById(id);
        return !(iChambreService.deleteById(id));
    }
}
