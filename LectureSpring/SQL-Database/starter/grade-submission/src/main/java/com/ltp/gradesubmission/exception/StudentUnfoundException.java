package com.ltp.gradesubmission.exception;

public class StudentUnfoundException extends RuntimeException{
  
  public StudentUnfoundException(Long studentId){
    super("The student with student id: '" + studentId + "' does not exist in our records");
  }
}
