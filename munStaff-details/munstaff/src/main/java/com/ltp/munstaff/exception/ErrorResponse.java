package com.ltp.munstaff.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
public class ErrorResponse {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timestamp;
  private String message;
  private String details;
  
  public ErrorResponse(String message, String details) {
    super();
    this.timestamp = LocalDateTime.now();
    this.message = message;
    this.details = details;
  }
}
