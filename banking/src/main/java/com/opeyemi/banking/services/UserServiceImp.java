package com.opeyemi.banking.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.opeyemi.banking.entity.User;
import com.opeyemi.banking.entity.UserSetup;
import com.opeyemi.banking.helpers.Helpers;
import com.opeyemi.banking.repository.UserRepository;
import com.opeyemi.banking.validators.Constants;

import lombok.*;

@AllArgsConstructor
@Service

public class UserServiceImp implements UserService{
  
  UserRepository userRepository;

  @Override
  public Boolean createUser(UserSetup request){
    // Implementing Logic for Creating a new user...

    // Check to see if the user already exists...
    if(userRepository.existsByUsername(request.getUsername())) return Constants.USER_ALREADY_EXISTS;

    // If User doesn't exists - then go ahead and create the user...
    User newUser = User.builder()
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .username(request.getUsername())
      .email(request.getEmail())
      .contactAddress(request.getContactAddress())
      .password(request.getPassword())
      .AccountNumber(Helpers.generateAcccountNumber())
      .Balance(request.getBalance())
      .build();
    userRepository.save(newUser);
    return true;

  }

  @Override
  public User fetchUser(Long id){
    Optional<User> user = userRepository.findById(id);
    if(user.isPresent()){
      return user.get();
    }
    return null;
  }
  
  @Override
  public User confirmLoginDetails(String username, String password){
    Optional<User> foundUser = userRepository.findByUsernameAndPassword(username,password);
    if (foundUser.isPresent()){
      return foundUser.get();
    }else{
      return null;
    }
  }
}
