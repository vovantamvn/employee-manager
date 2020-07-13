/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.DayOff;
import com.example.demo.model.User;
import com.example.demo.repository.DayOffRepositoryImp;
import com.example.demo.repository.Repository;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author luongle
 */
public class StaffController {

    private Repository repository;
    private DayOffRepositoryImp dayOffRepositoryImp;
    private LoginController loginController;

    public StaffController(Repository<User> repository) {
        this.repository = repository;
    }

    public StaffController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void thaydoimatkhau(String pas1, String pas2) {
        if (pas1.equals(pas2)) {
            
            User user = new User();
            int id = user.getId();
            user.setPassword(pas2);
            repository.update(id, user);
            JOptionPane.showMessageDialog(null, "Thành công");

        } else {

            JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không đúng ");

        }
    }

    public void dexuatnghi(Date ngay) {
        
        DayOff dayOff = new DayOff();
        
        dayOffRepositoryImp.create(dayOff);
    }
}
