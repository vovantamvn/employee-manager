package com.example.demo.controller;

import com.example.demo.RepositoryProvide;
import com.example.demo.model.User;
import com.example.demo.repository.Repository;

import java.util.List;

public class LoginController {
    private final Repository<User> repository;

    public LoginController(){
        this.repository = RepositoryProvide.getUserRepository();
    }

    public User login(String username, String password){
        List<User> users = repository.getAll();
        for (User user: users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        
        return null;
    }
}
