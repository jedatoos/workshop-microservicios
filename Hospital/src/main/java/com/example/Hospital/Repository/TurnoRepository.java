package com.example.Hospital.Repository;

import com.example.Hospital.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByOdontologoId(Long odontologoId);
    List<Turno> findByPacienteId(Long pacienteId);
}
