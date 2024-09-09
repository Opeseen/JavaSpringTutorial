package com.ltp.munstaff.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "staffs")

public class Staff {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstname;
  private String lastname;
  private String phone;
  private String address;
  @Column(name = "email", nullable = false, unique = true)
  private String email;
  private String state;
  private String city;
  private String nationality;
}

