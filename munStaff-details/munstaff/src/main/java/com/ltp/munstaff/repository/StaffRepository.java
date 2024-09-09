package com.ltp.munstaff.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltp.munstaff.entity.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long>{

  
}

