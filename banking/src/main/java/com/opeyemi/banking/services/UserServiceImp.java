package com.opeyemi.banking.services;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.stereotype.Service;

import com.opeyemi.banking.entity.Transactions;
import com.opeyemi.banking.entity.User;
import com.opeyemi.banking.helpers.Helpers;
import com.opeyemi.banking.helpers.TransactionRequest;
import com.opeyemi.banking.helpers.UserSetup;
import com.opeyemi.banking.repository.TransactionRepository;
import com.opeyemi.banking.repository.UserRepository;
import com.opeyemi.banking.validators.Constants;

import lombok.*;

@AllArgsConstructor
@Service

public class UserServiceImp implements UserService{
  
  UserRepository userRepository;
  TransactionRepository transactionRepository;

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
  public Transactions processCreditTransaction(TransactionRequest transactionRequest, String Id){
    if(fetchUser(Long.parseLong(Id)) == null) return null;
    User user = fetchUser(Long.parseLong(Id));
    BigDecimal currentUserBalance = user.getBalance();

    Transactions newTransaction = Transactions.builder()
      .amount(transactionRequest.getAmount())
      .descrition(transactionRequest.getDescription())
      .transType("Credit")
      .build();
    
    user.setBalance(Helpers.creditExistingBalance(currentUserBalance, transactionRequest.getAmount()));
    userRepository.save(user);
    newTransaction.setUser(user);
    return transactionRepository.save(newTransaction);
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
