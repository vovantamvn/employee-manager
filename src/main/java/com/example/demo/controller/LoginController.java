package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.Repository;
import com.example.demo.repository.UserRepositoryImp;

import java.util.List;

public class LoginController {
    private Repository<User> repository;

    public LoginController(){
        this.repository = new UserRepositoryImp();
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
