package com.ltp.munstaff.response.error;

public class ResourceAlreadyExist extends RuntimeException {

  public ResourceAlreadyExist(String email) {
    super("The input '" + email + "' already exist in our record '");
  };
};
