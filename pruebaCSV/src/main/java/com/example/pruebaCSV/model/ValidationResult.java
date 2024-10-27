package com.example.pruebaCSV.model;

public class ValidationResult {
    private int validCount;
    private int invalidCount;

    public ValidationResult(int validCount, int invalidCount) {
        this.validCount = validCount;
        this.invalidCount = invalidCount;
    }

    public int getValidCount() {
        return validCount;
    }

    public int getInvalidCount() {
        return invalidCount;
    }
}
