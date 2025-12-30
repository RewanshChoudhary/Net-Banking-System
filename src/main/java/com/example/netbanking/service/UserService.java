package com.example.netbanking.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.netbanking.dto.CreateRequestDto;
import com.example.netbanking.exception.DuplicateUserRequest;
import com.example.netbanking.model.Users;
import com.example.netbanking.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
      org.springframework.security.crypto.password.PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  void createUser(CreateRequestDto req) {
   
    if (userRepository.existsByEmail(req.getEmail())) {
      throw new  DuplicateUserRequest();


    }
    String password=passwordEncoder.encode(req.getPassword());

    Users user=Users.builder().name(req.getName())
    .email(req.getEmail())
    .address(req.getAddress())
    .phoneNo(req.getPhoneNo())
    .password(password)
    .createdAt(Instant)

     

  }
}
