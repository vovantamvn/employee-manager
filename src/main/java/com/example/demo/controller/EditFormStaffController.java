/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.RepositoryProvide;
import com.example.demo.repository.Repository;
import java.util.List;
import com.example.demo.model.User;
import java.util.ArrayList;


public class EditFormStaffController {
    private final Repository<User> repository;
    
    public EditFormStaffController(){
        repository = RepositoryProvide.getUserRepository();
    }
    
    public List<User> getAllStaff() {
        List<User> users = repository.getAll();
        List<User> staffs = new ArrayList<>();
        
        for(User item : users){
            if(item.getRole() == User.ROLE_EMPLOYEE){
                staffs.add(item);
            }
        }
        
        return staffs;
    }

    public User findUserByID(int id) {
        return repository.findById(id);
    }

    public boolean deleteUser(int id) {
        return repository.deleteById(id);
    }

    public boolean updateUser(int id, User user) {
        return repository.update(id, user);
    }
    
}
