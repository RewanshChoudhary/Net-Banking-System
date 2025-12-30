package com.example.netbanking.dto;

import java.time.Instant;

public class ApiError {
  private int status;
  private String message;
  private Instant timestamp;

  public ApiError(int status, String message, Instant timestamp) {
    this.status = status;
    this.message = message;
    this.timestamp = timestamp;
  }

  public static ApiError of(int status, String message, Instant timestamp) {
    return new ApiError(status, message, timestamp);

  }

}
