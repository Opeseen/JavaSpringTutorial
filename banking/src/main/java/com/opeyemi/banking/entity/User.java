package com.opeyemi.banking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long Id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "username", unique = true)
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "contact_address")
  private String contactAddress;

  @Column(name = "password")
  private String password;

  @Column(name = "account_number")
  private String AccountNumber;

  @Column(name = "balance")
  private Double Balance;

  
}
