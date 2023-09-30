package com.ltp.gradesubmission.exception;

public class NoRecordFoundException extends RuntimeException{

  public NoRecordFoundException(){
    super("No record found");
  }
  
}
