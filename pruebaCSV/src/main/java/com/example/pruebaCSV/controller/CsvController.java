package com.example.pruebaCSV.controller;

import com.example.pruebaCSV.cliente.ValidationClient;
import com.example.pruebaCSV.model.LineData;
import com.example.pruebaCSV.service.CsvReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/csv")
public class CsvController {

    private final ValidationClient validationClient;
    private final CsvReaderService csvReaderService;

    @Autowired
    public CsvController(CsvReaderService csvReaderService, ValidationClient validationClient) {
        this.csvReaderService = csvReaderService;
        this.validationClient = validationClient;
    }
 /*@GetMapping("/validate")

    public ResponseEntity<List<LineData>> validateCsvData() {
        String filePath = "D:\\people - Copy.csv";
        List<LineData> records;

        try {
            records = csvReaderService.readCsv(filePath);
            return ResponseEntity.ok(records);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }*/


    @GetMapping("/validate")
   public ResponseEntity<Map<String, Integer>> validateCsvData() {
        String filePath = "D:\\people - Copy.csv"; // Ruta fija del archivo CSV
        List<LineData> records;
        int validCount = 0;
        int invalidCount = 0;

        try {
            records = csvReaderService.readCsv(filePath); // Leer CSV desde la ruta fija
            //para enviar al micro servicio de validacion

            for (LineData record : records) {
                // Llamar al servicio de validación
                boolean isValid = validationClient.validateRecord(record); //  validateRecord retorna un boolean

                if (isValid) {
                    validCount++;
                } else {
                    invalidCount++;
                }
            }

            // Retornar el conteo de registros válidos e inválidos
            Map<String, Integer> result = new HashMap<>();
            result.put("validCount", validCount);
            result.put("invalidCount", invalidCount);
            return ResponseEntity.ok(result);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.<String, Integer>singletonMap("error", Integer.valueOf("Error al procesar el archivo CSV.")));
        }
    }
}
