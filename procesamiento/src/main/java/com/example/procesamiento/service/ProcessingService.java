package com.example.procesamiento.service;


import com.opencsv.CSVReader;
import org.springframework.stereotype.Service;

import java.io.FileReader;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessingService {
    public List<String[]> cargarYLeerArchivo(String rutaArchivo) {
        List<String[]> lineas = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(rutaArchivo))) {
            String[] linea;
            // Leer cada línea del archivo CSV
            while ((linea = reader.readNext()) != null) {
                lineas.add(linea); // Agregar la línea a la lista
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas; // Devolver la lista de líneas leídas
    }
}
