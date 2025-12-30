package com.example.netbanking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.netbanking.dto.CreateRequestDto;
import com.example.netbanking.model.Users;
import com.example.netbanking.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")

public class UserController {
 private final UserService userService;
   

  public UserController(UserService userService) {
	this.userService = userService;
}


  @PostMapping("/create")

  ResponseEntity<CreateRequestDto> createUser( @Valid @RequestBody CreateRequestDto request ){

    userService.createUser(request);


    return ResponseEntity
         .status(HttpStatus.OK)
         .body(request);

   
  }
}


