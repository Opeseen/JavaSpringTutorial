package com.opeyemi.banking.helpers;

import java.math.BigDecimal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class UserSetup {
  @NotBlank(message = "Firstname cannot be blank")
  private String firstName;

  @NotBlank(message = "Lastname cannot be blank")
  private String lastName;

  @NotBlank(message = "Username cannot be blank")
  private String username;

  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Invalid Email Entered")
  private String email;

  @NotBlank(message = "Contact cannot be blank")
  private String contactAddress;

  @NotBlank(message = "Password cannot be blank")
  private String password;
  private String confirmPassword;
  
  private String AccountNumber;

  private BigDecimal Balance;

  public UserSetup() {
    this.Balance = new BigDecimal(0.0);
  }


}
