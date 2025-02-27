package com.assignment.assignment.service;

import com.assignment.assignment.domain.User;
import com.assignment.assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }

    // Method to save a User
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    // Method to get a User by ID
    public User getUserById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }
}
