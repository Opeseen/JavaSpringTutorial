package com.ltp.munstaff.response.error;

public class PayGroupNotFoundException extends RuntimeException {
  public PayGroupNotFoundException(Long id) {
    super("No record found with id: '" + id);
  };
};
