package com.example.Hospital.controller;

import com.example.Hospital.model.Odontologo;
import com.example.Hospital.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {


    private final OdontologoService odontologoService;

    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> getAllOdontologos() {
        return odontologoService.getAllOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo getOdontologoById(@PathVariable Long id) {
        return odontologoService.getOdontologoById(id);
    }

    @PostMapping
    public Odontologo saveOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.saveOdontologo(odontologo);
    }

    @DeleteMapping("/{id}")
    public void deleteOdontologo(@PathVariable Long id) {
        odontologoService.deleteOdontologo(id);
    }
}
