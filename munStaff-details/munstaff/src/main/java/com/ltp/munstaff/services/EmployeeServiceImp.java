package com.ltp.munstaff.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.repository.EmployeeRepository;
import com.ltp.munstaff.response.error.EmployeeNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

  EmployeeRepository employeeRepository;

  @Override // SAVE ENTITY
  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  };

  @Override // GET SINGLE ENTITY
  public Employee getEmployee(Long id) {
    Optional<Employee> entity = employeeRepository.findById(id);
    if (entity.isPresent()) {
      return entity.get();
    }
    ;
    throw new EmployeeNotFoundException(id);
  };

  @Override // GET ALL ENTITY
  public List<Employee> getAllEmployee() {
    return (List<Employee>) employeeRepository.findAll();
  };

  @Override // UPDATE ENTITY
  public Employee updateEmployee(Long id, Employee employee) {
    Optional<Employee> entity = employeeRepository.findById(id);
    Employee confirmedEntity = fetchEmployee(entity, id);
    confirmedEntity.setFirstname(employee.getFirstname());
    confirmedEntity.setLastname(employee.getLastname());
    confirmedEntity.setPhone(employee.getPhone());
    confirmedEntity.setAddress(employee.getAddress());
    confirmedEntity.setEmail(employee.getEmail());
    confirmedEntity.setState(employee.getState());
    confirmedEntity.setCity(employee.getCity());
    confirmedEntity.setNationality(employee.getNationality());

    return employeeRepository.save(confirmedEntity);
  };

  // FIND ENTITY
  static Employee fetchEmployee(Optional<Employee> entity, Long id) {
    if (entity.isPresent())
      return entity.get();
    throw new EmployeeNotFoundException(id);
  };
};
