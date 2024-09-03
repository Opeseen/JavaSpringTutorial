package com.ltp.munstaff.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.munstaff.repository.StaffRepository;

@Service
public class StaffServiceImp implements StaffService {
 
  @Autowired
  private StaffRepository staffRepository;
  
}
