package com.example.Hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name="Odontologo")
public class Odontologo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDocumento;
    private String documentoIdentidad;
    private String nombre;
    private String apellido;
    private String tarjetaProfesional;
    private String especialidad;

    // Relación uno a muchos con Turno
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;

    // Getters and Setters
}
