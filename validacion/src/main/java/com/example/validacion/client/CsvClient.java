package com.example.validacion.client;

import com.example.validacion.model.LineData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "pruebaCSV", url = "http://localhost:8080") // Cambia el puerto si es necesario
public interface CsvClient {
    @GetMapping("/csv/records") // Cambia la ruta al endpoint correcto de `pruebaCSV`
    List<LineData> obtenerRegistrosCsv();
}
