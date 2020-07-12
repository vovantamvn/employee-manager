/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.model.UserDayOff;
import com.example.demo.utils.SQLServerConnectionProvideImp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vovantam
 */
public class UserDayOffRepositoryImp implements Repository<UserDayOff>{
    private Connection connection;
    
    public UserDayOffRepositoryImp() {
        SQLServerConnectionProvideImp connectionProvideImp = new SQLServerConnectionProvideImp();
        connection = connectionProvideImp.getConnection();

        if (connection == null) {
            throw new RuntimeException("SQL connection not must be null!");
        }
    }

    public UserDayOffRepositoryImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public UserDayOff create(UserDayOff obj) {
        String query = String.format("INSERT user_day_off VALUES(%d, %d);", obj.getUserId(), obj.getDayOffId());
        
        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return obj;
    }

    @Override
    public boolean update(int id, UserDayOff obj) {
        String query = String.format(
                "UPDATE user_day_off\n" +
                "SET\n" +
                "    user_id = %d,\n" +
                "    day_off_id = %d\n" +
                "WHERE\n" +
                "    id = %d;",
                obj.getUserId(),
                obj.getDayOffId(),
                id
        );
        
        try(Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public UserDayOff findById(int key) {
        String query = String.format(
                "SELECT\n" +
                "    id,\n" +
                "    user_id,\n" +
                "    day_off_id\n" +
                "FROM user_day_off \n" +
                "WHERE id = %d;", key
        );
        
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
             
            UserDayOff userDayOff = new UserDayOff();
            userDayOff.setId(resultSet.getInt(1));
            userDayOff.setUserId(resultSet.getInt(2));
            userDayOff.setDayOffId(resultSet.getInt(3));
             
            return userDayOff;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         
        return null;
    }

    @Override
    public boolean deleteById(int key) {
        String query = String.format("DELETE user_day_off WHERE id = %d;", key);
        
        try(Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<UserDayOff> getAll() {
        String query = String.format(
                "SELECT\n" +
                "    id,\n" +
                "    user_id,\n" +
                "    day_off_id\n" +
                "FROM user_day_off;\n"
        );
        
        List<UserDayOff> userDayOffs = new ArrayList<>();
        
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                UserDayOff userDayOff = new UserDayOff();
                userDayOff.setId(resultSet.getInt(1));
                userDayOff.setUserId(resultSet.getInt(2));
                userDayOff.setDayOffId(resultSet.getInt(3));
                
                userDayOffs.add(userDayOff);
            }
             
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        return userDayOffs;
    }
}
