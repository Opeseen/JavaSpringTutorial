package com.ltp.munstaff.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.repository.EmployeeRepository;
import com.ltp.munstaff.repository.PayGroupRepository;
import com.ltp.munstaff.response.error.NotFoundException;
import com.ltp.munstaff.response.error.ResourceAlreadyExist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImp implements EmployeeService {

  EmployeeRepository employeeRepository;
  PayGroupRepository payGroupRepository;

  @Override // SAVE EMPLOYEE
  public Employee saveEmployee(Employee employee) {
    if (employeeRepository.existsByEmail(employee.getEmail().toLowerCase().trim())) {
      throw new ResourceAlreadyExist("An employee already exist in our record with the email", employee.getEmail());
    }
    employee.setEmail(employee.getEmail().toLowerCase().trim());
    employee.setLastname(employee.getLastname().toLowerCase().trim());
    employee.setFirstname(employee.getFirstname().toLowerCase().trim());
    return employeeRepository.save(employee);
  };

  @Override // GET SINGLE EMPLOYEE
  public Employee getEmployee(Long id) {
    Optional<Employee> entity = employeeRepository.findById(id);
    Employee confirmedEmployee = StaticFetchEmployee(entity, id);

    return confirmedEmployee;
  };

  @Override
  public PayGroup getEmployeePayGroup(Long id) {
    Employee employee = getEmployee(id);
    return employee.getPayGroup();
  };

  @Override // GET ALL EMPLOYEE
  public List<Employee> getAllEmployee() {
    return (List<Employee>) employeeRepository.findAll();
  };

  @Override // UPDATE EMPLOYEE INFO
  public Employee updateEmployee(Long id, Employee employee) {
    Optional<Employee> entity = employeeRepository.findById(id);
    Employee confirmedEntity = StaticFetchEmployee(entity, id);

    if (!confirmedEntity.getEmail().equals(employee.getEmail())) {
      ExistingRecordFound(employee);
    }

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

  @Override
  public Employee updateEmployeePayGroup(Long employeeId, Long payGroupId, String type) {
    // Verify if an employee exist based on the Id
    Employee employee = getEmployee(employeeId);
    // Verify if a payGroup exist based on the Id
    Optional<PayGroup> payGroup = payGroupRepository.findById(payGroupId);
    // Verify if an payGroup was returned based on the findById request
    PayGroup verifiedPayGroup = PayGroupServiceImp.staticFetchPayGroup(payGroup, payGroupId);

    if (type != null && type.equals("delete")) {
      employee.setPayGroup(null);
      return employeeRepository.save(employee);
    }

    employee.setPayGroup(verifiedPayGroup);
    return employeeRepository.save(employee);
  };

  @Override // DELETE EMPLOYEE
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  };

  void ExistingRecordFound(Employee employee) {
    if (employeeRepository.existsByEmail(employee.getEmail().toLowerCase().trim())) {
      throw new ResourceAlreadyExist("An employee already exist in our record with the email",
          employee.getEmail());
    }
  };

  // STATIC FIND EMPLOYEE
  static Employee StaticFetchEmployee(Optional<Employee> entity, Long id) {
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new NotFoundException("No employee found with id", id);
  };

};
