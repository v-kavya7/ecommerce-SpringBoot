package com.example.E_commerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.E_commerce.entity.User;
import com.example.E_commerce.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        System.out.println("Entered Email: " + email);
        System.out.println("Entered Password: " + password);

        if(user != null){
            System.out.println("Database Password: " + user.getPassword());
        }

        if(user != null && user.getPassword().equals(password)){
            System.out.println("Login Successful");
            return user;
        }

        System.out.println("Login Failed");
        return null;
    }
}