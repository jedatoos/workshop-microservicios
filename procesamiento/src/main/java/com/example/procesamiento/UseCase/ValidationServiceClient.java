package com.example.procesamiento.UseCase;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "validation-service", url = "http://localhost:8081")
public interface ValidationServiceClient {
    @PostMapping("/api/validate")
    boolean validateRecord(@RequestBody CsvRecord record);
}
