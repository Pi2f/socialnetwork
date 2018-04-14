package com.polytech.services;

import com.polytech.persistence.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;

public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setUsername(user.getUsername());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }
}
