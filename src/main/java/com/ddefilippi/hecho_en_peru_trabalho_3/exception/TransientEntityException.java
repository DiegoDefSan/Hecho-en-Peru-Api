package com.ddefilippi.hecho_en_peru_trabalho_3.exception;

public class TransientEntityException extends RuntimeException {
    public TransientEntityException(String message) {
        super(message);
    }
}
