package com.ltp.munstaff.services;

import java.util.List;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.entity.PayGroup;

public interface EmployeeService {
  Employee saveEmployee(Employee staff);

  Employee updateEmployee(Long id, Employee staff);

  Employee getEmployee(Long id);

  PayGroup getEmployeePayGroup(Long id);

  Employee updateEmployeePayGroup(Long employeeId, Long payGroupId, String type);

  List<Employee> getAllEmployee();

  void deleteEmployee(Long id);
}
