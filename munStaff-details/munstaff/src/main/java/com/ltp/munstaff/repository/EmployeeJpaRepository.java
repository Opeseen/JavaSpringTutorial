package com.ltp.munstaff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltp.munstaff.entity.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

};
