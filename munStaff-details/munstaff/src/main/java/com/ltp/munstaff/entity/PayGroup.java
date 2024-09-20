package com.ltp.munstaff.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "paygroup")
public class PayGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NonNull
  private String category;
  @NonNull
  private Integer basic;
  @NonNull
  private Integer housing;
  @NonNull
  private Integer transport;
  @NonNull
  private Integer utility;
  @NonNull
  private Integer grossPay;
  private Integer tax;
  private Integer employeePensionContribution;
  private Integer employerPensionContribution;
  private Integer netPay;

  @JsonIgnore
  @OneToMany(mappedBy = "payGroup")
  private List<Employee> employee;
};
