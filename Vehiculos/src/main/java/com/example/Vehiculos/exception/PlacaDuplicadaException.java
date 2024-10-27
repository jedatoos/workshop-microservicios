package com.example.Vehiculos.exception;

import static com.example.Vehiculos.util.VehiculoConstants.PLACA_DUPLICADA;

public class PlacaDuplicadaException extends RuntimeException{
    public PlacaDuplicadaException() {
        super(PLACA_DUPLICADA); // Pasa el mensaje a la clase base (RuntimeException)
    }
}
