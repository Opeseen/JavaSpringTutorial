package com.ltp.munstaff.response.error;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
public class ErrorResponse {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Boolean error;
  private String message;
  private String details;
  private LocalDateTime timestamp;
  
  public ErrorResponse(Boolean error, String message, String details) {
    super();
    this.error = error;
    this.message = message;
    this.details = details;
    this.timestamp = LocalDateTime.now();
  };
}