package com.example.relationshipspractise.exception;

import com.example.relationshipspractise.model.onetoone.Owner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class OwnershipControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @ExceptionHandler(OwnerExeption.class)
    public ResponseEntity<?> handleOwnerException(OwnerExeption ex){
       return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders()).body(ex.getMessage());
    }
    @ExceptionHandler(HouseException.class)
    public ResponseEntity<?> handleHouseException(HouseException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(new HttpHeaders()).body(ex.getMessage());
    }

}
