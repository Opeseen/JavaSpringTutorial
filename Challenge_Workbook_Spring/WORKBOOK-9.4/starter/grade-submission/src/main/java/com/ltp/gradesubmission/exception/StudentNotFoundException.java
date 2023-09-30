package com.ltp.gradesubmission.exception;

public class StudentNotFoundException extends RuntimeException{
  
  public StudentNotFoundException(Long studentId){
    super("The student with student id: '" + studentId + "' does not exist in our records");
  }
}
