package com.example.reservation.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler(BlocNotFoundException.class)
    public ResponseEntity<Object> handleCourNotFoundException(BlocNotFoundException exception) {
        String errorMessage = "Custom error message for CourNotFoundException: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(ChambreNotFoundException.class)
    public ResponseEntity<Object> handleCourNotFoundException(ChambreNotFoundException exception) {
        String errorMessage = "Custom error message for CourNotFoundException: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(EtudiantNotFoundException.class)
    public ResponseEntity<Object> handleCourNotFoundException(EtudiantNotFoundException exception) {
        String errorMessage = "Custom error message for CourNotFoundException: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(FoyerNotFoundException.class)
    public ResponseEntity<Object> handleCourNotFoundException(FoyerNotFoundException exception) {
        String errorMessage = "Custom error message for CourNotFoundException: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<Object> handleCourNotFoundException(ReservationNotFoundException exception) {
        String errorMessage = "Custom error message for CourNotFoundException: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(UniversiteNotFoundException.class)
    public ResponseEntity<Object> handleCourNotFoundException(UniversiteNotFoundException exception) {
        String errorMessage = "Custom error message for CourNotFoundException: " + exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
