package com.example.reservation.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE) //les attributs privés
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Reservation {
    @Id
    private String idReservation;

    private LocalDate anneeUniversitaire;
    private boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Etudiant> etudiants;



}
