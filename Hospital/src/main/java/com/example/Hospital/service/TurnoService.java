package com.example.Hospital.service;


import com.example.Hospital.Repository.TurnoRepository;
import com.example.Hospital.exception.ResourceNotFoundException;
import com.example.Hospital.model.Odontologo;
import com.example.Hospital.model.Paciente;
import com.example.Hospital.model.Turno;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TurnoService {

    private final TurnoRepository turnoRepository;
    private final OdontologoService odontologoService;
    private final PacienteService pacienteService;

    public TurnoService(TurnoRepository turnoRepository, OdontologoService odontologoService, PacienteService pacienteService) {
        this.turnoRepository = turnoRepository;
        this.odontologoService = odontologoService;
        this.pacienteService = pacienteService;
    }

    // Método para guardar un turno
    public Turno saveTurno(Long odontologoId, Long pacienteId, Date fechaTurno) {
        Odontologo odontologo = odontologoService.getOdontologoById(odontologoId);
        Paciente paciente = pacienteService.getPacienteById(pacienteId);

        if (fechaTurno == null || fechaTurno.before(new Date())) {
            throw new IllegalArgumentException("La fecha es inválida");
        }

     Turno turno = new Turno();
        turno.setOdontologo(odontologo);
        turno.setPaciente(paciente);
        turno.setFechaTurno(fechaTurno);
        turno.setEstado(Turno.EstadoTurno.ASIGNADO);

        return turnoRepository.save(turno);
    }

    // Método para obtener turnos por odontólogo
    public List<Turno> getTurnosPorOdontologo(Long odontologoId) {
        return turnoRepository.findByOdontologoId(odontologoId);
    }

    // Método para obtener turnos por paciente
    public List<Turno> getTurnosPorPaciente(Long pacienteId) {
        return turnoRepository.findByPacienteId(pacienteId);
    }

    // Método para actualizar el estado de un turno
    public Turno updateEstadoTurno(Long id, Turno.EstadoTurno estado) {
        Turno turno = turnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado"));
        turno.setEstado(estado);
        return turnoRepository.save(turno);
    }

    // Método para cancelar un turno
    public Turno cancelarTurno(Long turnoId) {
        Turno turno = turnoRepository.findById(turnoId)
                .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con ID: " + turnoId));

        turno.setEstado(Turno.EstadoTurno.CANCELADO); // Cambiar estado a CANCELADO
        return turnoRepository.save(turno); // Guardar el turno actualizado
    }
}
