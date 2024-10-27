package com.example.Hospital.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Table(name="Turno")
@NoArgsConstructor
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private Date fechaTurno;

    @Enumerated(EnumType.STRING)
    private EstadoTurno estado;



    public enum EstadoTurno {
        ASIGNADO, CONFIRMADO, CANCELADO
    }

    // Getters and Setters
}
