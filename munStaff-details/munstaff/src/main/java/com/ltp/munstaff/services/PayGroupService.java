package com.ltp.munstaff.services;

import java.util.List;
import java.util.Set;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.entity.PayGroup;

public interface PayGroupService {
  PayGroup savePayGroup(PayGroup payGroup);

  PayGroup FetchPayGroup(Long id);

  PayGroup getPayGroup(Long id);

  Set<Employee> getPayGroupEmployee(Long id);

  PayGroup updatePayGroup(PayGroup payGroup, Long id);

  List<PayGroup> getAllPayGroup();

  void deletePayGroup(Long id);

  PayGroup addEmployeeToPayGroup(Long employeeId, Long payGroupId);
};