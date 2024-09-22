package com.ltp.munstaff.response.error;

public class ExistingRecordFoundException extends RuntimeException {
  public ExistingRecordFoundException(String message, Long id) {
    super(message + ": " + id);
  };
};
