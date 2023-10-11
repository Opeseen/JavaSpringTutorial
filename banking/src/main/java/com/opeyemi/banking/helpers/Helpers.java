package com.opeyemi.banking.helpers;

import java.math.BigDecimal;

public class Helpers {
  public static String generateAcccountNumber() {
    int n = 10;
    String numbers = "01234567890";
    StringBuilder sb = new StringBuilder(n);
    for(int i = 0; i < n; i++){
      int randonNumber = (int)(numbers.length() * Math.random());
      sb.append(numbers.charAt(randonNumber));
    }
    return sb.toString();
  }

  public static BigDecimal creditExistingBalance(BigDecimal currentBalance, String amountToCredit){
    BigDecimal creditAmout = new BigDecimal(amountToCredit);
    return currentBalance.add(creditAmout);
  }

  public static BigDecimal debitExistingBalance(BigDecimal currentBalance, String amountToDebit){
    BigDecimal debitAmout = new BigDecimal(amountToDebit);
    return currentBalance.add(debitAmout);
  }

  public static String emailMessageContent(String firstname, String lastname, String accountNumber){
    String message =  "Congratulations, " + firstname.toUpperCase() + " " + lastname.toUpperCase() +  " Your account have been successfully registered.\n\nYour account number is " + accountNumber + "\n\n Welcome Onboard!!!";
    return message;
  }

}
