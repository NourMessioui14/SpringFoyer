package com.example.reservation.Entities;

import com.example.reservation.Entities.Enumeration.TypeChambre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE) //les attributs privés
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;

    @ManyToOne

    private Bloc blocs;

    @OneToMany
    private Set<Reservation> reservations;




}
