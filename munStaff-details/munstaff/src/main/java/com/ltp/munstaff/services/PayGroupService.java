package com.ltp.munstaff.services;

import java.util.List;
import com.ltp.munstaff.entity.PayGroup;

public interface PayGroupService {
  PayGroup savePayGroup(PayGroup payGroup);
  PayGroup FetchPayGroup(Long id);
  PayGroup getPayGroup(Long id);
  PayGroup updatePayGroup(PayGroup payGroup, Long id);
  List<PayGroup> getAllPayGroup();
  void deletePayGroup(Long id);
};