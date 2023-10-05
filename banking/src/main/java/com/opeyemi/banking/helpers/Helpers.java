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

}
