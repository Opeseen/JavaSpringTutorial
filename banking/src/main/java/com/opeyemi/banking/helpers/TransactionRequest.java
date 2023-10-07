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

  private String transType;

  @NotBlank(message = "Description cannot be blank")
  private String description;


}
