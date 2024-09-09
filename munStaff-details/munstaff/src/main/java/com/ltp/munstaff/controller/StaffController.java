package com.ltp.munstaff.controller;

import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.munstaff.entity.Staff;
import com.ltp.munstaff.services.StaffService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@AllArgsConstructor
@RequestMapping("/mundial")
public class StaffController {
  
  StaffService staffService;

  @PostMapping("staff")
  public ResponseEntity<Staff>saveEntity(@RequestBody Staff staff){
      
      return new ResponseEntity<>(staffService.saveStaff(staff), HttpStatus.OK);
  }
  
}
