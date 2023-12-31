package com.banquito.core.banking.seguridadcliente.services;

public class CreacionException extends RuntimeException {
    public CreacionException(String message, Exception cause){
        super(message, cause);
    }

}
