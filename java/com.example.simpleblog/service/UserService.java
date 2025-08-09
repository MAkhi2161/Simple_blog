package com.example.simpleblog.service;

import com.example.simpleblog.entity.User;
import com.example.simpleblog.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection 
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    public void register(User user) {
        userRepository.save(user);
    }

    // Authenticate user by username and password
    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        return user != null;
    }

    // Find user by username (for validation)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
