package com.example.reservation.Exception;

public class ReservationNotFoundException extends RuntimeException{
    public ReservationNotFoundException(String message){
        super(message);
    }
}
