package com.ltp.munstaff.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltp.munstaff.entity.PayGroup;

@Repository
public interface PayGroupRepository extends CrudRepository<PayGroup, Long> {

};