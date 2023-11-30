package com.example.reservation.Entities;

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
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;
    private String nomFoyer;
    private long capaciteFoyer;

    @OneToOne(mappedBy = "foyers",cascade = CascadeType.ALL)
    @JsonIgnore
    private Universite universite;

    @OneToMany(mappedBy = "foyers",cascade = CascadeType.ALL)
    private Set <Bloc> blocs;


}
