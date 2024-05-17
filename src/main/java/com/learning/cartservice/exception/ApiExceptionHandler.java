package com.learning.cartservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ApiExceptionFormat> itemDetailsNotFound(ItemNotFoundException exception){
        ApiExceptionFormat apiExceptionFormat = new ApiExceptionFormat(exception.getMessage(), ZonedDateTime.now());
        return new ResponseEntity<>(apiExceptionFormat, HttpStatus.CONFLICT);
    }
}
