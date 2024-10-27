package com.example.validacion.service;

import com.example.validacion.client.CsvClient;
import com.example.validacion.model.LineData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class ValidacionService {

    // Cliente Feign para obtener registros de `pruebaCSV`
    @Autowired
    private CsvClient csvClient;

    // Expresión regular para validar correos
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    // Formato de fecha
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final LocalDate MIN_DATE = LocalDate.of(1980, 1, 1);

    // Títulos válidos
    private static final List<String> TITULOS_VALIDOS = List.of("Haematologist", "Phytotherapist", "Building Surveyor", "Insurance Account Manager", "Educational Psychologist");

    // Método para obtener y validar todos los registros CSV
    public void validarTodosLosRegistros() {
        List<LineData> registros = csvClient.obtenerRegistrosCsv(); // Obtén los registros desde `pruebaCSV`

        for (LineData registro : registros) {
            boolean esValido = validarRegistro(registro);
            if (!esValido) {
                // Manejo del registro inválido (puedes lanzar una excepción o registrar el error)
                System.out.println("Registro inválido: " + registro);
            }
        }
    }

    // Este método ahora recibe un objeto LineData
    public boolean validarRegistro(LineData lineData) {
        return validarEmail(lineData.getEmail()) &&
                validarFechaNacimiento(lineData.getBirthDate().toString()) &&
                validarTituloProfesional(lineData.getJobTitle());
    }

    public boolean validarEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public boolean validarFechaNacimiento(String fecha) {
        LocalDate fechaNacimiento = LocalDate.parse(fecha, DATE_FORMATTER);
        return fechaNacimiento.isAfter(MIN_DATE);
    }

    public boolean validarTituloProfesional(String titulo) {
        return TITULOS_VALIDOS.contains(titulo);
    }

    // Validar código postal y teléfono como opcionales
    public boolean validarCodigoPostal(String codigoPostal) {
        return codigoPostal != null && codigoPostal.matches("\\d{5}");
    }

    public boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("\\+\\d{10,15}");
    }
}