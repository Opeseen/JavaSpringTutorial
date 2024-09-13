package com.ltp.munstaff.services;

import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Staff;
import com.ltp.munstaff.exception.StaffNotFoundException;
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
    Optional<Staff> entity = staffRepository.findById(id);
    Staff confirmedEntity = fetchStaff(entity, id);
    confirmedEntity.setAddress("13 Mulero St");
    return staffRepository.save(confirmedEntity);
  }
  

  static Staff fetchStaff(Optional<Staff> entity, Long id){
    if(entity.isPresent()) return entity.get();
    throw new StaffNotFoundException(id);
  }
}
