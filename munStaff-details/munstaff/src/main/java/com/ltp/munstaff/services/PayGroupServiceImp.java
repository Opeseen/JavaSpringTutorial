package com.ltp.munstaff.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.repository.PayGroupRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PayGroupServiceImp implements PayGroupService {

  PayGroupRepository payGroupRepository;

  @Override
  public PayGroup savePayGroup(PayGroup payGroup) {
    return payGroupRepository.save(payGroup);
  };

  @Override
  public PayGroup getPayGroup(Long id) {
    if (id != null) {
      Optional<PayGroup> entity = payGroupRepository.findById(id);
      if (entity.isPresent()) {
        return entity.get();
      }
    }
    return null;
  };
};
