package com.example.E_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.E_commerce.entity.User;
import com.example.E_commerce.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {

        return userService.login(email, password);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }
}