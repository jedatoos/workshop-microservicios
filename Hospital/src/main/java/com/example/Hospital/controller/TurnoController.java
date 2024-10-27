package com.example.Hospital.controller;


import com.example.Hospital.model.Turno;
import com.example.Hospital.service.TurnoService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {


    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    // Crear un turno
    @PostMapping
    public Turno saveTurno(@RequestParam Long odontologoId, @RequestParam Long pacienteId, @RequestParam Date fechaTurno) {
        return turnoService.saveTurno(odontologoId, pacienteId, fechaTurno);
    }

    // Obtener turnos por odontólogo
    @GetMapping("/odontologo/{odontologoId}")
    public List<Turno> getTurnosPorOdontologo(@PathVariable Long odontologoId) {
        return turnoService.getTurnosPorOdontologo(odontologoId);
    }

    // Obtener turnos por paciente
    @GetMapping("/paciente/{pacienteId}")
    public List<Turno> getTurnosPorPaciente(@PathVariable Long pacienteId) {
        return turnoService.getTurnosPorPaciente(pacienteId);
    }

    // Cancelar turno
    @PatchMapping("/cancelar/{turnoId}")
    public Turno cancelarTurno(@PathVariable Long turnoId) {
        return turnoService.cancelarTurno(turnoId);
    }
}