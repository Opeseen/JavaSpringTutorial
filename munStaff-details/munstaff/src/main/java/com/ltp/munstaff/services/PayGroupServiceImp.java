package com.ltp.munstaff.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.helper.Helpers;
import com.ltp.munstaff.repository.EmployeeRepository;
import com.ltp.munstaff.repository.PayGroupRepository;
import com.ltp.munstaff.response.error.ExistingRecordFoundException;
import com.ltp.munstaff.response.error.NotFoundException;
import com.ltp.munstaff.response.error.ResourceAlreadyExist;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PayGroupServiceImp implements PayGroupService {

  PayGroupRepository payGroupRepository;
  EmployeeRepository employeeRepository;

  @Override // SAVE PAY-GROUP
  public PayGroup savePayGroup(PayGroup payGroup) {
    if (payGroupRepository.existsByCategory(payGroup.getCategory().toLowerCase().trim())) {
      throw new ResourceAlreadyExist("A payGroup category already exist in our record with the name",
          payGroup.getCategory());
    }
    ;
    BigDecimal GrossPay = Helpers.generateGrossPay(payGroup.getBasic(), payGroup.getHousing(), payGroup.getTransport(),
        payGroup.getUtility());
    BigDecimal EmployeePension = Helpers.generateEmployeePension(payGroup.getBasic(), payGroup.getHousing(),
        payGroup.getTransport());
    BigDecimal EmployerPension = Helpers.generateEmployerPension(payGroup.getBasic(), payGroup.getHousing(),
        payGroup.getTransport());
    BigDecimal NetPay = Helpers.generateNetPay(GrossPay, payGroup.getTax(), EmployeePension);

    payGroup.setCategory(payGroup.getCategory().toLowerCase().trim());
    payGroup.setGrossPay(GrossPay);
    payGroup.setEmployeePensionContribution(EmployeePension);
    payGroup.setEmployerPensionContribution(EmployerPension);
    payGroup.setNetPay(NetPay);

    return payGroupRepository.save(payGroup);
  };

  @Override // GET PAY-GROUP
  public PayGroup getPayGroup(Long id) {
    Optional<PayGroup> entity = payGroupRepository.findById(id);
    if (entity.isPresent()) {
      return entity.get();
    }
    throw new NotFoundException("No payGroup found with id", id);
  };

  @Override
  public Set<Employee> getPayGroupEmployee(Long id) {
    PayGroup payGroup = getPayGroup(id);
    return payGroup.getEmployee();
  };

  @Override // GET ALL PAY-GROUP
  public List<PayGroup> getAllPayGroup() {
    return (List<PayGroup>) payGroupRepository.findAll();
  };

  @Override // FETCH PAY-GROUP
  public PayGroup FetchPayGroup(Long id) {
    if (id != null) {
      Optional<PayGroup> entity = payGroupRepository.findById(id);
      if (entity.isPresent()) {
        return entity.get();
      }
    }
    return null;
  };

  @Override // UPDATE PAY-GROUP
  public PayGroup updatePayGroup(PayGroup payGroup, Long id) {
    Optional<PayGroup> entity = payGroupRepository.findById(id);
    PayGroup confirmedEntity = staticFetchPayGroup(entity, id);

    if (!confirmedEntity.getCategory().equals(payGroup.getCategory())) {
      ExistingRecordFound(payGroup);
    }

    BigDecimal GrossPay = Helpers.generateGrossPay(payGroup.getBasic(), payGroup.getHousing(), payGroup.getTransport(),
        payGroup.getUtility());
    BigDecimal EmployeePension = Helpers.generateEmployeePension(payGroup.getBasic(), payGroup.getHousing(),
        payGroup.getTransport());
    BigDecimal EmployerPension = Helpers.generateEmployerPension(payGroup.getBasic(), payGroup.getHousing(),
        payGroup.getTransport());
    BigDecimal NetPay = Helpers.generateNetPay(GrossPay, payGroup.getTax(), EmployeePension);

    confirmedEntity.setCategory(payGroup.getCategory());
    confirmedEntity.setBasic(payGroup.getBasic());
    confirmedEntity.setHousing(payGroup.getHousing());
    confirmedEntity.setTransport(payGroup.getTransport());
    confirmedEntity.setUtility(payGroup.getUtility());
    confirmedEntity.setTax(payGroup.getTax());

    confirmedEntity.setGrossPay(GrossPay);
    confirmedEntity.setEmployeePensionContribution(EmployeePension);
    confirmedEntity.setEmployerPensionContribution(EmployerPension);
    confirmedEntity.setNetPay(NetPay);

    return payGroupRepository.save(confirmedEntity);
  };

  @Override // DELETE PAY-GROUP
  public void deletePayGroup(Long id) {
    payGroupRepository.deleteById(id);
  };

  @Override
  public PayGroup addEmployeeToPayGroup(Long employeeId, Long payGroupId) {
    // Verify if a pay group exist based on the Id
    PayGroup payGroup = getPayGroup(payGroupId);
    // Verify if an employee exist based on the Id
    Optional<Employee> employee = employeeRepository.findById(employeeId);
    // Verify if an employee was returned based on the findById request
    Employee verifiedEmployee = EmployeeServiceImp.StaticFetchEmployee(employee, employeeId);

    // This will throw an error if the employee is already attach to a payGroup
    checkIsPayGroupAttached(verifiedEmployee, employeeId);

    payGroup.getEmployee().add(verifiedEmployee);
    return payGroupRepository.save(payGroup);
  };

  // This method will prevent double payGroup for an employee.
  void checkIsPayGroupAttached(Employee entity, Long employeeId) {
    PayGroup employeePayGroup = entity.getPayGroup();
    if (employeePayGroup != null) {
      throw new ExistingRecordFoundException("A payGroup already exist for employee with id", employeeId);
    }
    ;
  };

  void ExistingRecordFound(PayGroup payGroup) {
    if (payGroupRepository.existsByCategory(payGroup.getCategory().toLowerCase().trim())) {
      throw new ResourceAlreadyExist("A payGroup category already exist in our record with the name",
          payGroup.getCategory());
    }
  };

  // STATIC FIND ENTITY
  static PayGroup staticFetchPayGroup(Optional<PayGroup> entity, Long id) {
    if (entity.isPresent())
      return entity.get();
    throw new NotFoundException("No payGroup found with id", id);
  };

};
