package com.opeyemi.banking;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.opeyemi.banking.exceptions.ErrorResponse;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<Object> handleNullPointerException(NullPointerException ex){
    ErrorResponse error = new ErrorResponse(Arrays.asList("The requested resources is a non existing"));
    return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
  }
  
}
