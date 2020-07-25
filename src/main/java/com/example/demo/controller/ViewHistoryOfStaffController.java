/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.RepositoryProvide;
import com.example.demo.model.DayOff;
import com.example.demo.model.User;
import com.example.demo.model.UserDayOff;
import com.example.demo.model.UserDayOffModel;
import com.example.demo.repository.Repository;
import java.util.ArrayList;
import java.util.List;


public class ViewHistoryOfStaffController {
    private final Repository<User> userRepository;
    private final Repository<DayOff> dayOffRepository;
    private final Repository<UserDayOff> userDayOffRepository;
    
    public ViewHistoryOfStaffController() {
        userRepository = RepositoryProvide.getUserRepository();
        dayOffRepository = RepositoryProvide.getDayOffRepository();
        userDayOffRepository = RepositoryProvide.getUserDayOffRepository();
    }
    
    public List<UserDayOffModel> getStaffDayOffs() {
        List<UserDayOff> userDayOffs = userDayOffRepository.getAll();
        List<UserDayOffModel> models = new ArrayList<>();
        
        for(UserDayOff item : userDayOffs){
            DayOff dayOff = dayOffRepository.findById(item.getDayOffId());
            
            if(dayOff.getStatus() != DayOff.ALLOW) {
                continue;
            }
            
            User user = userRepository.findById(item.getUserId());
            
            UserDayOffModel model = new UserDayOffModel();
            model.setId(item.getId());
            model.setName(user.getName());
            model.setNumberDayOff(dayOff.getNumberDay());
            model.setDate(dayOff.getDate());
            model.setComment(dayOff.getComment());
            
            models.add(model);
        }
        
        return models;
    }

    public void sendMessager(int id, String messenger) {
        UserDayOff userDayOff = userDayOffRepository.findById(id);
        int dayOffId = userDayOff.getDayOffId();
        DayOff dayOff = dayOffRepository.findById(dayOffId);
        
        dayOff.setComment(messenger);
        dayOffRepository.update(dayOffId, dayOff);
    }
    
}
