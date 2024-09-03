package com.ltp.munstaff.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ltp.munstaff.entity.Staff;

@Repository
public class StaffRepository {
  
  private List<Staff> staff = Arrays.asList(
    new Staff("ope","alabi"),
    new Staff("mike","john")
  );

  public List<Staff> geStaffs(){
    return staff;
  }
}

