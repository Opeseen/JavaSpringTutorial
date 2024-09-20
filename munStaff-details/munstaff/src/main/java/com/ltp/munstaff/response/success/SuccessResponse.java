package com.ltp.munstaff.response.success;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
public class SuccessResponse {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private Boolean success;
  private Number result;
  private List<?> message;
  private String details;
  private LocalDateTime timestamp;

  public SuccessResponse(Boolean success, Number result, List<?> message, String details) {
    super();
    this.success = success;
    this.result = result;
    this.message = message;
    this.details = details;
    this.timestamp = LocalDateTime.now();
  };
};
