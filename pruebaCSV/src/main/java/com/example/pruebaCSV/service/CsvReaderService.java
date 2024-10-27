package com.example.pruebaCSV.service;

import com.example.pruebaCSV.model.LineData;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {

    public List<LineData> readCsv(String filePath) throws IOException {
        List<LineData> records = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Ajustar si la fecha en CSV tiene otro formato

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {  // Utiliza withFirstRecordAsHeader()

            for (CSVRecord csvRecord : csvParser) {
                try {
                    String userId = csvRecord.get("User Id");
                    String firstName = csvRecord.get("First Name");
                    String lastName = csvRecord.get("Last Name");
                    String sex = csvRecord.get("Sex");
                    String email = csvRecord.get("Email");
                    String phone = csvRecord.get("Phone");

                    // Manejo de fechas con formateador
                    LocalDate birthDate = LocalDate.parse(csvRecord.get("Date of birth"), dateFormatter);

                    String jobTitle = csvRecord.get("Job Title");

                    LineData lineData = new LineData(userId, firstName, lastName, sex, email, phone, birthDate, jobTitle);
                    records.add(lineData);

                } catch (DateTimeParseException e) {
                    System.err.println("Error al parsear la fecha: " + csvRecord.get("Date of birth"));

                } catch (IllegalArgumentException e) {
                    System.err.println("Error al leer los campos del CSV: " + e.getMessage());
                    // Manejo de campos faltantes o malformados
                }
            }
        }

        return records;

    }
}

