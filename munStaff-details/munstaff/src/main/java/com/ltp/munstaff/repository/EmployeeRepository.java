package com.ltp.munstaff.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ltp.munstaff.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

  
}

