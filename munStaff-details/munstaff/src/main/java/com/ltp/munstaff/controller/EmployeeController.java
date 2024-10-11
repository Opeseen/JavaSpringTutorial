package com.ltp.munstaff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.response.Constant.ConstantResponse;
import com.ltp.munstaff.response.success.SuccessResponse;
import com.ltp.munstaff.services.EmployeeService;
import com.ltp.munstaff.services.PayGroupService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/mundial")
public class EmployeeController {
  // AN "ENTITY" IS REFERRED TO AS AN EMPLOYEE
  EmployeeService employeeService;
  PayGroupService payGroupService;

  @PostMapping("/employee")
  public ResponseEntity<?> saveEntity(@RequestBody Employee entity) {
    Employee newEntity = employeeService.saveEmployee(entity);
    SuccessResponse successDetails = new SuccessResponse(true, ConstantResponse.Single, ConstantResponse.Employee_Saved,
        newEntity);
    return new ResponseEntity<>(successDetails, HttpStatus.CREATED);
  };

  @GetMapping("/employee/{id}")
  public ResponseEntity<?> getEntity(@PathVariable Long id) {
    Employee entity = employeeService.getEmployee(id);
    SuccessResponse successDetails = new SuccessResponse(true, ConstantResponse.Single, ConstantResponse.Success,
        entity);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };

  @GetMapping("/employee/all")
  public ResponseEntity<?> getAllEntity() {
    List<Employee> entity = employeeService.getAllEmployee();
    SuccessResponse successDetails = new SuccessResponse(true, entity.size(), ConstantResponse.Success, entity);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };

  @GetMapping("/employee/{id}/paygroup")
  public ResponseEntity<?> getEntityPayGroup(@PathVariable Long id) {
    PayGroup entityPayGroup = employeeService.getEmployeePayGroup(id);
    SuccessResponse successDetails = new SuccessResponse(true, ConstantResponse.Single, ConstantResponse.Success,
        entityPayGroup);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };

  @PutMapping("/employee/{id}")
  public ResponseEntity<?> updateEntity(@PathVariable Long id, @RequestBody Employee entity) {
    Employee updatedEntity = employeeService.updateEmployee(id, entity);
    SuccessResponse successDetails = new SuccessResponse(true, ConstantResponse.Single, ConstantResponse.Success,
        updatedEntity);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };

  @PutMapping("/employee/{employeeId}/paygroup/{payGroupId}/update")
  public ResponseEntity<?> updateEntityPayGroup(@PathVariable Long employeeId, @PathVariable Long payGroupId,
      @RequestParam(required = false) String type) {
    Employee entity = employeeService.updateEmployeePayGroup(employeeId, payGroupId, type);
    SuccessResponse successDetails = new SuccessResponse(true, ConstantResponse.Single, ConstantResponse.Success,
        entity);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };

  @DeleteMapping("/employee/{id}")
  public ResponseEntity<HttpStatus> deleteEntity(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  };

};
