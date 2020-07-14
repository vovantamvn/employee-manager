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
import com.example.demo.repository.Repository;
import java.util.List;

public class StaffController {

    private final Repository<UserDayOff> userDayOffRepository;
    private final Repository<DayOff> dayOffRepository;
    private final Repository<User> userRepository;

    public StaffController() {
        userRepository = RepositoryProvide.getUserRepository();
        dayOffRepository = RepositoryProvide.getDayOffRepository();
        userDayOffRepository = RepositoryProvide.getUserDayOffRepository();
    }

    public boolean changPassword(User user, String p1) {
        user.setPassword(p1);
        
        return userRepository.update(user.getId(), user);
    }

    public float getDayOff(int userId) {
        float sum = 0;
        
        List<UserDayOff> userDayOffs = userDayOffRepository.getAll();
        
        for(UserDayOff userDayOff : userDayOffs){
            if(userDayOff.getUserId() != userId){
                continue;
            }
            
            DayOff dayOff = dayOffRepository.findById(userDayOff.getDayOffId());
            
            if(dayOff.getStatus() == DayOff.ALLOW){
                sum += dayOff.getNumberDay();
            }
        }
        
        return sum;
    }
    
    public boolean submitDayOff(int id, DayOff dayOff) {
        dayOff.setStatus(DayOff.NULL);
        
        DayOff result = dayOffRepository.create(dayOff);
        
        if(result == null) {
            return false;
        }
        
        
        List<DayOff> dayOffs = dayOffRepository.getAll();
        int idDayOff = dayOffs.get(dayOffs.size() - 1).getId();
        
        UserDayOff userDayOff = new UserDayOff();
        userDayOff.setUserId(id);
        userDayOff.setDayOffId(idDayOff);
        
        return userDayOffRepository.create(userDayOff) != null;
    }

    public boolean cancelDayOff(int id) {
        UserDayOff userDayOff = getLastDayOffOfUser(id);
        
        if(userDayOff == null){
            return false;
        }
        
        DayOff dayOff = dayOffRepository.findById(userDayOff.getDayOffId());
        
        dayOff.setStatus(DayOff.REFUSE);
        
        return dayOffRepository.update(dayOff.getId(), dayOff);
    }
    
    private UserDayOff getLastDayOffOfUser(int id) {
        List<UserDayOff> userDayOffs = userDayOffRepository.getAll();
        
        int lastIndex = userDayOffs.size() - 1;
        
        for(int i = lastIndex; i>=0; i++){
            
            if (userDayOffs.get(i).getUserId() == id) {
                return userDayOffs.get(i);
            }
        }
        
        return null;
    }
}
