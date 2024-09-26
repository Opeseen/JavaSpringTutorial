package com.ltp.munstaff.helper;

import java.math.BigDecimal;
import java.math.*;

public class Helpers {
  public static BigDecimal generateGrossPay(BigDecimal basic, BigDecimal housing, BigDecimal transport, BigDecimal utility){
    BigDecimal totalGrossPay = basic.add(housing).add(transport).add(utility);

    return  totalGrossPay;
  };

  public static BigDecimal generateEmployeePension(BigDecimal basic, BigDecimal housing, BigDecimal transport){
    BigDecimal totalGrossPay = basic.add(housing).add(transport);
    BigDecimal multiplier = BigDecimal.valueOf(0.08);

    BigDecimal employeePension = totalGrossPay.multiply(multiplier).setScale(2, RoundingMode.UP);
  
    return employeePension;
  };

  public static BigDecimal generateEmployerPension(BigDecimal basic, BigDecimal housing, BigDecimal transport){
    BigDecimal totalGrossPay = basic.add(housing).add(transport);
    BigDecimal multiplier = BigDecimal.valueOf(0.10);

    BigDecimal employerPension = totalGrossPay.multiply(multiplier).setScale(2, RoundingMode.UP);
  
    return employerPension;
  };
};