package com.example.demo.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({Exception.class})
    public String handleAll(final Exception ex,
                            final WebRequest request) {
        return ex.getMessage();
    }
}
