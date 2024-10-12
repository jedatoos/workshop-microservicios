package com.example.pruebaCSV.cliente;

import com.example.pruebaCSV.model.LineData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "validation", url = "http://localhost:8081") // Cambia la URL según sea necesario
public interface ValidationClient {
    @PostMapping("/validate")
    boolean validateRecord(@RequestBody LineData lineData);
}