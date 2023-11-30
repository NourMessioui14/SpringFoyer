package com.example.reservation.Exception;

public class ChambreNotFoundException extends RuntimeException{
    public ChambreNotFoundException(String message){
        super(message);
    }

}
