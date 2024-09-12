package com.ltp.munstaff.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Staff;
import com.ltp.munstaff.repository.StaffRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StaffServiceImp implements StaffService {
 
  StaffRepository staffRepository;

  @Override
  public Staff saveStaff(Staff staff){
    return staffRepository.save(staff);
  }

  @Override
  public Staff updateStaff(Long id, Staff staff){
    Optional<Staff> coyStaff = staffRepository.findById(id);
    if(coyStaff.isPresent()) System.out.println(coyStaff.get());
    System.out.println("Good");
    return staffRepository.save(staff);
  }
  
}
