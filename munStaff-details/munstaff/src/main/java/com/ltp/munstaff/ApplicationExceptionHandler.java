package com.ltp.munstaff;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
  
  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<Object> handleDataIntegrityException(DataIntegrityViolationException ex){
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);

  }
}
