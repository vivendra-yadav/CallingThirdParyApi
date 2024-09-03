package com.scaler.myfirstapi.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Void> handleArithmeticException() {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       return responseEntity;
    }
}
