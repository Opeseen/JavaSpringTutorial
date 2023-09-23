package com.ltp.contacts.exception;

public class NoContactException extends RuntimeException {
  public NoContactException(String id){
    super("No Matching Record Found For id '"+ id +"'");
  }

}
