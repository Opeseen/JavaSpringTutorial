package com.ltp.gradesubmission.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ltp.gradesubmission.entity.User;
import com.ltp.gradesubmission.exception.EntityNotFoundException;
import com.ltp.gradesubmission.exception.UserAlreadyExistException;
import com.ltp.gradesubmission.repository.UserRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
	private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User saveUser(User user) {
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername().toUpperCase());
        if(foundUser.isPresent()) throw new UserAlreadyExistException(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUsername(user.getUsername().toUpperCase());
        return userRepository.save(user);
    }

    static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }
    
}
