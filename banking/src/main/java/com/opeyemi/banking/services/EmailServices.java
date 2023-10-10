package com.opeyemi.banking.services;

import com.opeyemi.banking.helpers.EmailSender;

public interface EmailServices {
  void sendEmail(EmailSender emailInfo);
}
