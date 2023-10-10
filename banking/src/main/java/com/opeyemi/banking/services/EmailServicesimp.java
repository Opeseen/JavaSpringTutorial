package com.opeyemi.banking.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.opeyemi.banking.helpers.EmailSender;

import lombok.*;

@AllArgsConstructor

@Service
public class EmailServicesimp implements EmailServices{
  
  JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String emailSender;

  @Override
  public void sendEmail(EmailSender emailSender){

  }
}
