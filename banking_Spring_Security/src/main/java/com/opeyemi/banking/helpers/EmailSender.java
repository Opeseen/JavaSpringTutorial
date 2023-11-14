package com.opeyemi.banking.helpers;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EmailSender {
  private String recipient;
  private String message;
  private String subject;
}
