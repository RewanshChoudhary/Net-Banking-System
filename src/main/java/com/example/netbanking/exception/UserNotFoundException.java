package com.example.netbanking.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends DomainException {
  @Override
  HttpStatus status() {
    return HttpStatus.NOT_FOUND;

  }
}


