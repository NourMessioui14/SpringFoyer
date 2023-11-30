package com.example.reservation.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE) //les attributs privés
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEtudiant;
    private String nomEt;
    private long cin;
    private String ecole;
    private Date dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;
}
