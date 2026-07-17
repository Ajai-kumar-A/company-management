package com.mitrahsoft.company_management.exception;

public class OfficialDetailsAlreadyExistException extends RuntimeException{
    public OfficialDetailsAlreadyExistException(String message) {
        super(message);
    }
}
