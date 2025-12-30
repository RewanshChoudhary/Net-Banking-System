package com.example.netbanking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password4j.BcryptPassword4jPasswordEncoder;

@Configuration

public class SecurityFilter {

  @Bean
  PasswordEncoder passwordEncoder(){
    return new BcryptPassword4jPasswordEncoder();

  }
}
