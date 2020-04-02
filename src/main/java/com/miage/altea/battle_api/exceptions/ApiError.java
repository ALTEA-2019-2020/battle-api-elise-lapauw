package com.miage.altea.battle_api.exceptions;

import org.springframework.http.HttpStatus;

public class ApiError extends RuntimeException {

    private HttpStatus status;
    private String message;

    public ApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
}