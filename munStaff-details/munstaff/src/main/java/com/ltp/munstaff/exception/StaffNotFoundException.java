package com.ltp.munstaff.exception;

public class StaffNotFoundException extends RuntimeException{

  public StaffNotFoundException(Long id){
    super("No record found with id: '" + id);
  }
}
