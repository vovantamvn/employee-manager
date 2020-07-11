package com.example.demo;

import com.example.demo.controller.LoginController;
import com.example.demo.view.Login;

import javax.swing.*;

public class MainFrame extends JFrame {

    public static int WIDTH = 800;
    public static int HEIGHT = 600;

    public MainFrame() {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

        UserRepository userRepository = new UserRepository();
        LoginController loginController = new LoginController(userRepository);
        Login loginView = new Login(loginController);
        loginView.setLocation(0, 100);

        setContentPane(loginView);
    }
}
