package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientAlreadyExistException.class)
    public ResponseEntity<ErrorResult> handle(ClientAlreadyExistException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage(),400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ErrorResult errorResult = new ErrorResult( "用户名不合法",400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResult> handleConstraintViolationException(ClientNotFoundException ex){
        ErrorResult errorResult = new ErrorResult(ex.getMessage(),404);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }




}
