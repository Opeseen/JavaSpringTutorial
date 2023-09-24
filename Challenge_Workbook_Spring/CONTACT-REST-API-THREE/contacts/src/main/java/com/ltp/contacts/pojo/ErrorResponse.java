package com.ltp.contacts.pojo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
  private List<String> message;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
  private LocalDateTime timeStamp;

  public ErrorResponse(List<String> message) {
    this.message = message;
    timeStamp = LocalDateTime.now();
  }

  public List<String> getMessage() {
    return this.message;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }

  public LocalDateTime getTimeStamp() {
    return this.timeStamp;
  }

  public void setTimeStamp(LocalDateTime timeStamp) {
    this.timeStamp = timeStamp;
  }

}
