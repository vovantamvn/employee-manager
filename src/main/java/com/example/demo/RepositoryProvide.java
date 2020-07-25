/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.model.DayOff;
import com.example.demo.model.User;
import com.example.demo.model.UserDayOff;
import com.example.demo.repository.DayOffRepositoryImp;
import com.example.demo.repository.Repository;
import com.example.demo.repository.UserDayOffRepositoryImp;
import com.example.demo.repository.UserRepositoryImp;
import com.example.demo.utils.SQLServerConnectionProvideImp;
import java.sql.Connection;


public class RepositoryProvide {
    private static final Connection connection;
    private static final Repository<User> userRepository;
    private static final Repository<DayOff> dayOffRepository;
    private static final Repository<UserDayOff> userDayOffRepository;
    
    static {
        SQLServerConnectionProvideImp connectionProvideImp = new SQLServerConnectionProvideImp();
        connection = connectionProvideImp.getConnection();

        if (connection == null) {
            throw new RuntimeException("SQL connection not must be null!");
        }
        
        userRepository = new UserRepositoryImp(connection);
        dayOffRepository = new DayOffRepositoryImp(connection);
        userDayOffRepository = new UserDayOffRepositoryImp(connection);           
    }

    public static Repository<User> getUserRepository() {
        return userRepository;
    }

    public static Repository<DayOff> getDayOffRepository() {
        return dayOffRepository;
    }

    public static Repository<UserDayOff> getUserDayOffRepository() {
        return userDayOffRepository;
    }
    
}
