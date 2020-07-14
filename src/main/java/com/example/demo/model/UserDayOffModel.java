/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.time.LocalDate;

public class UserDayOffModel {
    private int id;
    private String name;
    private LocalDate date;
    private float numberDayOff;
    private String comment;

    public UserDayOffModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getNumberDayOff() {
        return numberDayOff;
    }

    public void setNumberDayOff(float numberDayOff) {
        this.numberDayOff = numberDayOff;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
}
