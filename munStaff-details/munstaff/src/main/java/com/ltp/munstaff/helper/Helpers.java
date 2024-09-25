package com.ltp.munstaff.helper;

import java.math.BigDecimal;

public class Helpers {
  public static BigDecimal generateGrossPay(BigDecimal basic, BigDecimal housing, BigDecimal transport, BigDecimal utility){
    BigDecimal totalGrossPay = basic.add(housing).add(transport).add(utility);
    System.out.println(totalGrossPay);
    System.out.println(0.08);
    return  totalGrossPay;
  };

  public static BigDecimal generateEmployeePension(BigDecimal basic, BigDecimal housing, BigDecimal transport){
    BigDecimal totalGrossPay = basic.add(housing).add(transport);
    // BigDecimal employeePension = totalGrossPay.multiply();
    return null;
  };

  public static BigDecimal generateEmployerPension(){

    return null;
  };
};