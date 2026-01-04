package com.example.netbanking.service;

import java.time.OffsetDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.netbanking.dto.CreateRequestDto;
import com.example.netbanking.exception.DuplicateResourceRequest;
import com.example.netbanking.model.Users;
import com.example.netbanking.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
	this.userRepository = userRepository;
	this.passwordEncoder = passwordEncoder;
}

	public void createUser(CreateRequestDto req) {
   
    if (userRepository.existsByEmail(req.getEmail())) {
      throw new  DuplicateResourceRequest();


    }
    String password=passwordEncoder.encode(req.getPassword());
    OffsetDateTime time=OffsetDateTime.now();


    Users user=Users.builder().name(req.getName())
    .email(req.getEmail())
    .address(req.getAddress())
    .phoneNo(req.getPhoneNo())
    .createdAt(time)
    .passwordHash(password)
    .updatedAt(OffsetDateTime.now())
    .build();

    userRepository.save(user);






     

  }
}
