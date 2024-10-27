package com.example.Vehiculos.model;


import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="Vehiculo")
@Data
@NoArgsConstructor

public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia para generar la clave primaria
    private Long id; // Campo de identificación, clave primaria

    @Column(name = "placa", nullable = false, unique = true, length = 10)
    private String placa;

    @Column(name = "marca", nullable = false, length = 100)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private int modelo;

    @Column(name = "kilometraje", nullable = false)
    private int kilometraje;

    @Column(name = "estado", nullable = false)
    private boolean estado;
}
