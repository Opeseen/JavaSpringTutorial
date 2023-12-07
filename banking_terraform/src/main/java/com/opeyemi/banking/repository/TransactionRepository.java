package com.opeyemi.banking.repository;

import java.util.*;

import org.springframework.data.repository.CrudRepository;

import com.opeyemi.banking.entity.Transactions;

public interface TransactionRepository extends CrudRepository<Transactions, Long>{
    List<Transactions> findByUsersId(Long Id);
}
