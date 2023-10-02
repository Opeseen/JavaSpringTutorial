package com.opeyemi.banking.repository;

import org.springframework.data.repository.CrudRepository;

import com.opeyemi.banking.entity.User;
import java.util.*;

public interface UserRepository extends CrudRepository<User, Long> {
  Optional<User> findByUsernameAndPassword(String username, String password);
  Boolean existsByUsername(String username);
}
