package com.ltp.munstaff.services;

import com.ltp.munstaff.entity.PayGroup;

public interface PayGroupService {
  PayGroup savePayGroup(PayGroup payGroup);

  PayGroup getPayGroup(Long id);
};