package com.opeyemi.banking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.opeyemi.banking.helpers.EmailSender;

@Service
public class EmailSvcImp implements EmailServices{

  @Autowired
  JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String emailSenderAddress;

  @Override
  public void sendEmail(EmailSender emailSender){
    try {
      SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
      simpleMailMessage.setFrom(emailSenderAddress);
      simpleMailMessage.setTo(emailSender.getRecipient());
      simpleMailMessage.setText(emailSender.getMessage());
      simpleMailMessage.setSubject(emailSender.getSubject());

      javaMailSender.send(simpleMailMessage);

    } catch (MailException e) {
      throw new RuntimeException("Error while sending email to user");
    }

  }

}
