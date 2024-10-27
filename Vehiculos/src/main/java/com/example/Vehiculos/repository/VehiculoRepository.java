package com.example.Vehiculos.repository;


import com.example.Vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    boolean existsByPlaca(String placa);
    List<Vehiculo> findByEstado(boolean estado);
    Optional<Vehiculo> findByPlaca(String placa);
    void deleteByPlaca(String placa);
}
