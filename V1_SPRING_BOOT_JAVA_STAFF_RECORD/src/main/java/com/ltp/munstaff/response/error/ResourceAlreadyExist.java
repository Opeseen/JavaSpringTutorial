package com.ltp.munstaff.response.error;

public class ResourceAlreadyExist extends RuntimeException {

  public ResourceAlreadyExist(String message, String identity) {
    super(message + ": " + identity );
  };
};
