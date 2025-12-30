package com.example.netbanking.exception;

import org.springframework.http.HttpStatus;

public  class DuplicateUserRequest extends DomainException{

  @Override
  HttpStatus status(){
    return HttpStatus.BAD_REQUEST;

  }}



