package com.ltp.munstaff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.munstaff.entity.Employee;
import com.ltp.munstaff.response.success.SuccessResponse;
import com.ltp.munstaff.services.EmployeeService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@AllArgsConstructor
@RequestMapping("/mundial")
public class EmployeeController {
  
  EmployeeService employeeService;

  @GetMapping("/employee/{id}")
  public ResponseEntity<Employee>getEntity(@PathVariable Long id) {
    return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
  };
  
  @GetMapping("/employee/all")
  public ResponseEntity<?>getAllEntity() {
    List<Employee> entity = employeeService.getAllEmployee();
    SuccessResponse successDetails = new SuccessResponse(true, entity.size(), entity, null);
    return new ResponseEntity<>(successDetails, HttpStatus.OK);
  };
  
  @PostMapping("/employee")
  public ResponseEntity<Employee>saveEntity(@RequestBody Employee entity){
    return new ResponseEntity<>(employeeService.saveEmployee(entity), HttpStatus.CREATED);
  };
    
  @PutMapping("/employee/{id}")
  public ResponseEntity<Employee>updateEntity(@PathVariable Long id, @RequestBody Employee entity) {
    return new ResponseEntity<>(employeeService.updateEmployee(id, entity), HttpStatus.OK);
  };
  
};
