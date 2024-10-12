package com.example.validacion.controller;

import com.example.validacion.model.LineData;
import com.example.validacion.service.ValidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate")
public class ValidacionController {


    private final ValidacionService validacionService;
    @Autowired
    public ValidacionController(ValidacionService validacionService) {
        this.validacionService = validacionService;
    }

    @PostMapping
    public boolean validateRecord(@RequestBody LineData lineData) {
        return validacionService.validarRegistro(lineData);
    }
}
