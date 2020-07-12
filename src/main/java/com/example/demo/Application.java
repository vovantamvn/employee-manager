package com.example.demo;

import com.example.demo.model.DayOff;
import com.example.demo.model.User;
import com.example.demo.repository.DayOffRepositoryImp;
import com.example.demo.repository.UserRepositoryImp;
import com.example.demo.view.admin.AdminFrame;

import java.time.LocalDate;

public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new AdminFrame().setVisible(true);
    }
}
