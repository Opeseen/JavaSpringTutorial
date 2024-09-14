package com.ltp.munstaff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.munstaff.entity.Employees;
import com.ltp.munstaff.services.StaffService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
@AllArgsConstructor
@RequestMapping("/mundial")
public class StaffController {
  
  StaffService staffService;

  @PostMapping("/staff")
  public ResponseEntity<Employees>saveEntity(@RequestBody Employees entity){
      
      return new ResponseEntity<>(staffService.saveStaff(entity), HttpStatus.CREATED);
  }

  
  @PutMapping("/staff/{id}")
  public ResponseEntity<Employees>updateEntity(@PathVariable Long id, @RequestBody Employees entity) {
      
      return new ResponseEntity<>(staffService.updateStaff(id, entity), HttpStatus.OK);
  }
  
}
