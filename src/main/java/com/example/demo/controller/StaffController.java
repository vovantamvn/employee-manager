/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author luongle
 */
public class StaffController {
    public void thaydoimatkhau(String pas1, String pas2){
        if(pas1.equals(pas2)){
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,"Thành công");
            
            
        }
        else{
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,"Mật khẩu xác nhận không đúng ");
            return;
        }
    }
    
}
