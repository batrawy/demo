package com.example.orangetest.exception;

import org.springframework.http.HttpStatus;

public class ExcepationPayload {
    private final String message;
    private final HttpStatus httpStatus;

    public ExcepationPayload(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
