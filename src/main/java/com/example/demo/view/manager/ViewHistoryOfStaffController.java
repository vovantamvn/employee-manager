/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.view.manager;

import com.example.demo.model.DayOff;
import com.example.demo.model.User;
import com.example.demo.model.UserDayOff;
import com.example.demo.model.UserDayOffModel;
import com.example.demo.repository.DayOffRepositoryImp;
import com.example.demo.repository.Repository;
import com.example.demo.repository.UserDayOffRepositoryImp;
import com.example.demo.repository.UserRepositoryImp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovantam
 */
public class ViewHistoryOfStaffController {
    private Repository<User> userRepository;
    private Repository<DayOff> dayOffRepository;
    private Repository<UserDayOff> userDayOffRepository;
    
    public ViewHistoryOfStaffController() {
        userRepository = new UserRepositoryImp();
        dayOffRepository = new DayOffRepositoryImp();
        userDayOffRepository = new UserDayOffRepositoryImp();
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
            
            models.add(model);
        }
        
        return models;
    }
    
}
