package com.ltp.munstaff.services;

import java.util.List;

import com.ltp.munstaff.entity.Employee;

public interface EmployeeService {
  Employee saveEmployee(Employee staff);
  Employee updateEmployee(Long id, Employee staff);
  Employee getEmployee(Long id);
  List<Employee> getAllEmployee();
}
