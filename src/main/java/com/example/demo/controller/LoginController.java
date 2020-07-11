package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.Repository;

import java.util.List;

public class LoginController {
    private Repository repository;

    public LoginController(Repository<User> userRepository){
        this.repository = userRepository;
    }

    public boolean login(String username, String password){
        List<User> users = repository.getAll();
        for (User user: users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
