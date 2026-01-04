package com.example.netbanking.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.netbanking.dto.ApiError;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  ResponseEntity<ApiError> userNotFound(UserNotFoundException ex) {
    return ResponseEntity
        .status(ex.status())
        .body(new ApiError(ex.status().value(), "User Not found with the details", Instant.now()));

  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
    String message = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .findFirst()
        .map(err -> err.getField() + ": " + err.getDefaultMessage())
        .orElse("Validation failed");

    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ApiError(400, message, Instant.now()));

  }

  @ExceptionHandler(DuplicateResourceRequest.class)
  ResponseEntity<ApiError> handleDuplicateRequest(DuplicateResourceRequest ex) {
    return ResponseEntity.status(ex.status()).body(new ApiError(400, "User already exists  ", Instant.now()));

  } 
}
