package com.ltp.munstaff.services;

import com.ltp.munstaff.entity.Employees;

public interface StaffService {
  Employees saveStaff(Employees staff);
  Employees updateStaff(Long id, Employees staff);
}
