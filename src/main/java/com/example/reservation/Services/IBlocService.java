package com.example.reservation.Services;

import com.example.reservation.Entities.Bloc;

import java.util.List;

public interface IBlocService {

    Bloc addBloc(Bloc b);
    Bloc update(Bloc b);
    List<Bloc> getAll();
    Bloc getById(long id);
    boolean deleteById(long id);
    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
    public void testSchedulure();



    }
