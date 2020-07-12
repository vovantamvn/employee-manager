package com.example.demo.model;

import java.time.LocalDate;

public class DayOff {
    private int id;
    private LocalDate date;
    private String comment;
    private float numberDay;
    private int status;

    public static final int NULL = 0;
    public static final int ALLOW = 1;
    public static final int REFUSE = -1;

    public DayOff() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(float numberDay) {
        this.numberDay = numberDay;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DayOff{" +
                "id=" + id +
                ", date=" + date +
                ", comment='" + comment + '\'' +
                ", numberDay=" + numberDay +
                ", status=" + status +
                '}';
    }
}
