/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

/**
 *
 * @author vovantam
 */
public class UserDayOff {
    private int id;
    private int userId;
    private int dayOffId;

    public UserDayOff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDayOffId() {
        return dayOffId;
    }

    public void setDayOffId(int dayOffId) {
        this.dayOffId = dayOffId;
    }

    @Override
    public String toString() {
        return "UserDayOff{" + "id=" + id + ", userId=" + userId + ", dayOffId=" + dayOffId + '}';
    }
    
    
}
