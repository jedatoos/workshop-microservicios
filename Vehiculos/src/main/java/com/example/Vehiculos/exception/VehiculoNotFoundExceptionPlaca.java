package com.example.Vehiculos.exception;

import static com.example.Vehiculos.util.VehiculoConstants.PLATE_NOT_FOUND;

public class VehiculoNotFoundExceptionPlaca extends RuntimeException{
    public VehiculoNotFoundExceptionPlaca(String placa) {
        super(PLATE_NOT_FOUND + placa);
    }
}
