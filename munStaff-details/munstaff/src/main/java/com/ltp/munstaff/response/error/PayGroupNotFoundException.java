package com.ltp.munstaff.response.error;

public class PayGroupNotFoundException extends RuntimeException {
  public PayGroupNotFoundException(Long id) {
    super("No pay group record found with id: '" + id);
  };
};
