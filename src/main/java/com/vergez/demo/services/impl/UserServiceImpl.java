package com.vergez.demo.services.impl;

import org.springframework.stereotype.Service;

import com.vergez.demo.entities.User;
import com.vergez.demo.repository.UserRepository;
import com.vergez.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

}
