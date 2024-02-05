package com.example.TechItEasy.controllers;

import com.example.TechItEasy.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object>
    exception(RecordNotFoundException exception){
        return new ResponseEntity<Object>(
                exception.getMessage(), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(value = IndexOutOfBoundsException.class)
    public ResponseEntity<Object>
    exception(IndexOutOfBoundsException exception) {
        return new ResponseEntity<>(
                "ID niet gevonden in de database", HttpStatus.NOT_FOUND);
    }


}
