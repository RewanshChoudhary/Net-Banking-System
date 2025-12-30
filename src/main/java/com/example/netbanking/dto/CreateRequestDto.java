package com.example.netbanking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CreateRequestDto{
  @NotBlank(message="Name is required")

  private String name;
  @NotBlank(message="Email is required")
  @Email(message="Email is invalid")
  private String email;
  @NotBlank(message="Phone no is required")
  @Size(min=10,max=12)
  private String phoneNo;
  @NotBlank(message=" password is required and must be atleast 8 characters")

  private String password;
 @NotBlank(message=" Address should be provided")

  private String address;

  

}
