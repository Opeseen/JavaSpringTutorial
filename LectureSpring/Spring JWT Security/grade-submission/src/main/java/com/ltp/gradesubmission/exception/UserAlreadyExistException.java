package com.ltp.gradesubmission.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String username){
        super("The username: '" + username + "' already exists on our record: '");
    }
}
