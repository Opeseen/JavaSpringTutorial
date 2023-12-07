package com.opeyemi.banking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

  @Column(name = "account_balance")
  private BigDecimal Balance;

  @CreationTimestamp
  @Column(name = "creation_date")
  private LocalDateTime dateCreated;

  @JsonIgnore
  @OneToMany(mappedBy = "users", cascade = CascadeType.ALL )
  private List<Transactions> transactions;
  
}
