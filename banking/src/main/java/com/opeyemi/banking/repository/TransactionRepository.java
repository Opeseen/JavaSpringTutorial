package com.opeyemi.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.opeyemi.banking.entity.Transactions;

public interface TransactionRepository extends CrudRepository<Transactions, Long>{
  
}
