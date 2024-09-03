package com.ltp.munstaff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ltp.munstaff.entity.Staff;
import com.ltp.munstaff.services.StaffService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StaffController {
  @Autowired
  private StaffService staffService;

  @GetMapping("/staffs")
  @ResponseBody
  public Staff getStaff() {
      return new Staff("ope","alabi");
  }
  
}
