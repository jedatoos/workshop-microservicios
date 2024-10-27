package com.example.Vehiculos.controller;

import com.example.Vehiculos.exception.PlacaDuplicadaException;
import com.example.Vehiculos.model.Vehiculo;
import com.example.Vehiculos.repository.VehiculoRepository;
import com.example.Vehiculos.service.VehiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;
    private final VehiculoRepository vehiculoRepository;


    @PostMapping
    public ResponseEntity<Vehiculo> saveVehiculo(@RequestBody Vehiculo vehiculo) {
        // Validar si la placa ya existe
        if (vehiculoRepository.existsByPlaca(vehiculo.getPlaca())) {
            throw new PlacaDuplicadaException();
        }

        Vehiculo savedVehiculo = vehiculoService.save(vehiculo);
        return new ResponseEntity<>(savedVehiculo, HttpStatus.CREATED);

    }

    // Obtener todos los vehículos
    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<Vehiculo> toggleEstado(@PathVariable Long id) {
        Vehiculo vehiculoActualizado = vehiculoService.toggleEstado(id);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @GetMapping("/en-reparacion")
    public ResponseEntity<List<Vehiculo>> listarVehiculosEnReparacion() {
        List<Vehiculo> vehiculosEnReparacion = vehiculoService.listarVehiculosEnReparacion();
        return ResponseEntity.ok(vehiculosEnReparacion);
    }

    @DeleteMapping("/eliminar/{placa}")
    public ResponseEntity<String> eliminarVehiculoPorPlaca(@PathVariable String placa) {
        // Llamar al servicio para eliminar el vehículo
        vehiculoService.eliminarVehiculoPorPlaca(placa);
        return ResponseEntity.ok("Vehicle with placa " + placa + " has been deleted.");
    }



}