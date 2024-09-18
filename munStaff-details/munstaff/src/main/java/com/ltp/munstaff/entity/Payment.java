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
@ToString
@Entity
@Table(name = "payment")

public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Number basic;
  private Number housing;
  private Number transport;
  private Number utility;
  private Number grossPay;
  private Number tax;
  private Number employeePensionContribution;
  private Number employerPensionContribution;
  private Number netPay;
  private String categories;
};
