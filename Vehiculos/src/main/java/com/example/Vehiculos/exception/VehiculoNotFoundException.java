package com.example.Vehiculos.exception;

import static com.example.Vehiculos.util.VehiculoConstants.VEHICLE_NOT_FOUND_WITH_ID;

public class VehiculoNotFoundException extends RuntimeException {
    public VehiculoNotFoundException(Long id) {
        super(VEHICLE_NOT_FOUND_WITH_ID + id);
    }
}