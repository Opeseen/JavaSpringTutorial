package com.ltp.munstaff.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ltp.munstaff.entity.Employee;
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
  public PayGroup getPayGroup(Long id){
    Optional<PayGroup> entity = payGroupRepository.findById(id);
    if(entity.isPresent()){
      return entity.get();
    }
    throw new PayGroupNotFoundException(id);
  };

  @Override
  public List<PayGroup> getAllPayGroup(){
    return (List<PayGroup>) payGroupRepository.findAll();
  };

  @Override
  public PayGroup FetchPayGroup(Long id) {
    if (id != null) {
      Optional<PayGroup> entity = payGroupRepository.findById(id);
      if (entity.isPresent()) {
        return entity.get();
      }
    }
    return null;
  };

  @Override
  public PayGroup updatePayGroup(PayGroup payGroup, Long id){
    Optional<PayGroup> entity = payGroupRepository.findById(id);
    PayGroup confirmedEntity = StaticFetchPayGroup(entity, id);
    confirmedEntity.setCategory(payGroup.getCategory());
    confirmedEntity.setBasic(payGroup.getBasic());
    confirmedEntity.setHousing(payGroup.getHousing());
    confirmedEntity.setTransport(payGroup.getTransport());
    confirmedEntity.setUtility(payGroup.getUtility());

    return payGroupRepository.save(confirmedEntity);
  };

  @Override // DELETE ENTITY
  public void deletePayGroup(Long id){
    payGroupRepository.deleteById(id);
  };


  // STATIC FIND ENTITY
  static PayGroup StaticFetchPayGroup(Optional<PayGroup> entity, Long id) {
    if (entity.isPresent())
      return entity.get();
    throw new PayGroupNotFoundException(id);
  };

};
