package com.example.netbanking.dto;

import com.example.netbanking.model.enums.AccountType;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CreateAccountDto{

  @NotBlank

  public AccountType accountType;
  

  





}
