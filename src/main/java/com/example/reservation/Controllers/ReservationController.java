package com.example.reservation.Controllers;

import com.example.reservation.Entities.Reservation;
import com.example.reservation.Services.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("reservation")
public class ReservationController {
    public final IReservationService iReservationService;
    @GetMapping
    public List<Reservation> getAll(){
        return iReservationService.getAll();
    }
    @GetMapping("{id}")
    public Reservation getById(@PathVariable String id){
        return iReservationService.getById(id);
    }
    @PostMapping
    public Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }
    @PutMapping("{id}")
    public Reservation update(@PathVariable String id ,@RequestBody Reservation r){
        return iReservationService.update(r,id);
    }
    @DeleteMapping("{id}")
    public boolean deleteById(@PathVariable String id){
        iReservationService.deleteById(id);
        return !(iReservationService.deleteById(id));
    }
    @GetMapping("/getbydate")
    public Reservation getReservationById(@RequestParam("Date") Date date){
        return  iReservationService.getReservationParAnneeUniversitaire(date);
    }
}
