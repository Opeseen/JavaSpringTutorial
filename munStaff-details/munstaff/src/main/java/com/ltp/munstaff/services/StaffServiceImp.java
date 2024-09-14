package com.ltp.munstaff.services;

import java.util.Optional;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Employees;
import com.ltp.munstaff.exception.StaffNotFoundException;
import com.ltp.munstaff.repository.StaffRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StaffServiceImp implements StaffService {
 
  StaffRepository staffRepository;

  @Override
  public Employees saveStaff(Employees staff){
    return staffRepository.save(staff);
  }

  @Override
  public Employees updateStaff(Long id, Employees staff){
    Optional<Employees> entity = staffRepository.findById(id);
    Employees confirmedEntity = fetchStaff(entity, id);
    confirmedEntity.setAddress("13 Mulero St");
    return staffRepository.save(confirmedEntity);
  }
  

  static Employees fetchStaff(Optional<Employees> entity, Long id){
    if(entity.isPresent()) return entity.get();
    throw new StaffNotFoundException(id);
  }
}
