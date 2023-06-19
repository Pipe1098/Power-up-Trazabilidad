package com.pragma.trazabilidad.domain.exceptions;

public class LogNoFoundException extends RuntimeException {
    public LogNoFoundException(String message) {
        super(message);
    }
}
