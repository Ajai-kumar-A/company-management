package com.mitrahsoft.company_management.exception;

public class RecordsNotFoundException extends RuntimeException {
    public RecordsNotFoundException(String message) {
        super(message);
    }
}
