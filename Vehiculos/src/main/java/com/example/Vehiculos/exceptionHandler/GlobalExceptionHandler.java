package com.example.Vehiculos.exceptionHandler;

import com.example.Vehiculos.exception.PlacaDuplicadaException;
import com.example.Vehiculos.exception.VehiculoNotFoundException;
import com.example.Vehiculos.exception.VehiculoNotFoundExceptionPlaca;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class GlobalExceptionHandler {



    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(PlacaDuplicadaException.class)
    @ResponseBody
    public String handlePlacaDuplicadaException(PlacaDuplicadaException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleGenericException(Exception ex) {
        return "An error occurred: " + ex.getMessage();
    }

    // Manejo global de la excepción VehiculoNotFoundException
    @ExceptionHandler(VehiculoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleVehiculoNotFoundException(VehiculoNotFoundException ex) {
        return ex.getMessage(); // Mensaje específico para esta excepción
    }

    @ExceptionHandler(VehiculoNotFoundExceptionPlaca.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleVehiculoNotFoundExceptionPlaca(VehiculoNotFoundException ex) {
        return ex.getMessage(); // Mensaje específico para esta excepción
    }


}
