package com.example.demo.model;

import java.time.LocalDate;

public class DayOff {
    private int id;
    private LocalDate date;
    private Status status;

    public enum Status {
        ALLOW, REFUSE, NULL
    }

    public DayOff() {
        status = null;
    }

}
