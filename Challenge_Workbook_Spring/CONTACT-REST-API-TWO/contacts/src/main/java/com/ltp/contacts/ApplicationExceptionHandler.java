package com.ltp.contacts;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ltp.contacts.exception.NoContactException;
import com.ltp.contacts.pojo.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler {
  @ExceptionHandler(NoContactException.class)
  public ResponseEntity<Object> handleContactNotFoundException(NoContactException ex){
    ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
    return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
  }
}
