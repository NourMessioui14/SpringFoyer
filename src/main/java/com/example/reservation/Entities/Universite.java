package com.example.reservation.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE) //les attributs privés
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresse;

    @OneToOne(cascade = CascadeType.ALL)
    private Foyer foyers;

}
