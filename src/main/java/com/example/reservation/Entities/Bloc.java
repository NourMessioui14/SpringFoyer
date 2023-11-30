package com.example.reservation.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    private Foyer foyers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "blocs")
    private Set<Chambre> chambres;

}
