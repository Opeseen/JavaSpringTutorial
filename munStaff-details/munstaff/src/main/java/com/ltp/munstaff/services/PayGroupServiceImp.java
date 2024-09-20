package com.ltp.munstaff.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.PayGroup;
import com.ltp.munstaff.repository.PayGroupRepository;
import com.ltp.munstaff.response.error.PayGroupNotFoundException;

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
    Optional<PayGroup> entity = payGroupRepository.findById(id);
    if (entity.isPresent()) {
      return entity.get();
    }
    ;
    throw new PayGroupNotFoundException(id);
  };
};
