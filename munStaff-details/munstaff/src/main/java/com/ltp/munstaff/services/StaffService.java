package com.ltp.munstaff.services;

import com.ltp.munstaff.entity.Staff;

public interface StaffService {
  Staff saveStaff(Staff staff);
  Staff updateStaff(Long id, Staff staff);
}
