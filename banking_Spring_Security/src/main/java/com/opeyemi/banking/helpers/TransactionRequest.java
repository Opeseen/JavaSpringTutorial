package com.opeyemi.banking.helpers;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest {

  @NotBlank(message = "Amount cannot be blank")
  @Min(value = 100, message = "Amount cannot be less than 100")
  private String amount;

  private String transType;

  @NotBlank(message = "Description cannot be blank")
  private String description;


}
