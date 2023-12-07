package com.opeyemi.banking.services;

import com.opeyemi.banking.entity.Transactions;
import com.opeyemi.banking.entity.User;
import com.opeyemi.banking.helpers.TransactionRequest;
import com.opeyemi.banking.helpers.UserSetup;

import java.util.*;

public interface UserService {
  Boolean createUser(UserSetup user);
  User fetchUser(Long id);
  User confirmLoginDetails(String username, String password );
  Transactions processCreditTransaction(TransactionRequest transactionRequest, String Id);
  Boolean processDebitTransaction(TransactionRequest transactionRequest, String Id);
  List<Transactions> getUserTransactionHistory(String Id);
}
