package com.ltp.munstaff.response.error;

public class EmployeeNotFoundException extends RuntimeException {

  public EmployeeNotFoundException(Long id) {
    super("No employee record found with id: '" + id);
  };
};
