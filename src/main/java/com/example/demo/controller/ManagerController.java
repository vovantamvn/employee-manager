/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.RepositoryProvide;
import com.example.demo.model.DayOff;
import com.example.demo.model.UserDayOff;
import com.example.demo.model.User;
import com.example.demo.model.UserDayOffModel;
import com.example.demo.repository.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovantam
 */
public class ManagerController {
    private final Repository<User> userRepository;
    private final Repository<DayOff> dayOffRepository;
    private final Repository<UserDayOff> userDayOffRepository;
    
    public ManagerController() {
        userRepository = RepositoryProvide.getUserRepository();
        dayOffRepository = RepositoryProvide.getDayOffRepository();
        userDayOffRepository = RepositoryProvide.getUserDayOffRepository();
    }

    public List<UserDayOffModel> getUserDayOffModelWhereStatusEqualZero() {
        List<UserDayOffModel> models = new ArrayList<>();
        List<UserDayOff> userDayOffs = userDayOffRepository.getAll();
        
        for(UserDayOff item : userDayOffs){
            DayOff dayOff = dayOffRepository.findById(item.getDayOffId());
            
            if(dayOff.getStatus() != DayOff.NULL) {
                continue;
            }
            
            User user = userRepository.findById(item.getUserId());
            
            UserDayOffModel model = new UserDayOffModel();
            model.setId(item.getId());
            model.setName(user.getName());
            model.setNumberDayOff(dayOff.getNumberDay());
            model.setDate(dayOff.getDate());
            
            models.add(model);
        }
        
        return models;
    }
    
    public boolean setStatusOfOffer(int idOfUserDayOff, int mode) {
        if(mode != DayOff.ALLOW && mode != DayOff.REFUSE){
            return false;
        }
        
        UserDayOff userDayOff = userDayOffRepository.findById(idOfUserDayOff);
        
        if(userDayOff == null){
            return false;
        }
        
        int id = userDayOff.getDayOffId();
        DayOff dayOff = dayOffRepository.findById(id);
        dayOff.setStatus(mode);
        
        return dayOffRepository.update(id, dayOff);
    }

}
