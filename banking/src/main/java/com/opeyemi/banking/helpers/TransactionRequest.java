package com.opeyemi.banking.helpers;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

  @NotBlank(message = "Amount cannot be blank")
  private String amount;

  @NotBlank(message = "Transaction type cannot be blank")
  private String transType;

  @NotBlank(message = "DEscription cannot be blank")
  private String description;

}
