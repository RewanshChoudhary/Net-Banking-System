package com.example.netbanking.exception;

import org.springframework.http.HttpStatus;

public abstract class DomainException extends RuntimeException {

  abstract HttpStatus status();
}




