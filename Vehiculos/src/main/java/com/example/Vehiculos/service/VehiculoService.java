package com.example.Vehiculos.service;

import com.example.Vehiculos.exception.VehiculoNotFoundException;
import com.example.Vehiculos.exception.VehiculoNotFoundExceptionPlaca;
import com.example.Vehiculos.model.Vehiculo;
import com.example.Vehiculos.repository.VehiculoRepository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }
 // Guardar
    public Vehiculo save(Vehiculo vehiculo){

            return vehiculoRepository.save(vehiculo);
    }

   // Listar

    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    // Actualizar estado
    public Vehiculo toggleEstado(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new VehiculoNotFoundException(id));

        vehiculo.setEstado(!vehiculo.isEstado());
        return vehiculoRepository.save(vehiculo);
    }
    // estado
    public List<Vehiculo> listarVehiculosEnReparacion() {
        // Buscar todos los vehículos con estado "true" (en reparación)
        return vehiculoRepository.findByEstado(true);
    }
    @Transactional
    public void eliminarVehiculoPorPlaca(String placa) {
        // Verificar si el vehículo existe por la placa
        Vehiculo vehiculo = vehiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new VehiculoNotFoundExceptionPlaca(placa));

        // Eliminar el vehículo por la placa
        vehiculoRepository.deleteByPlaca(placa);
    }

}
