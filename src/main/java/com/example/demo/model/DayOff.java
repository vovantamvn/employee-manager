package com.example.demo.model;

import java.time.LocalDate;

public class DayOff {
    private int id;
    private LocalDate date;
    private String comment;
    private float numberDay;
    private Status status;

    public enum Status {
        ALLOW, REFUSE, NULL
    }

    public DayOff() {
        status = Status.NULL;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
