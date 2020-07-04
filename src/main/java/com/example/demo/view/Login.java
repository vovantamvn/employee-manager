package com.example.demo.view;

import com.example.demo.controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.logging.Logger;

public class Login extends JPanel {

    public static int WIDTH = 800;
    public static int HEIGHT = 500;

    public static int ELE_WIDTH = 200;
    public static int ELE_HEIGHT = 30;
    public static int MARGIN = 5;

    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameText;
    private JTextField passwordText;

    private LoginController loginController;

    private static Logger logger = Logger.getLogger(Login.class.getName());

    public Login(LoginController loginController) {
        this.loginController = loginController;
        setSize(WIDTH, HEIGHT);
        setLayout(null);

        usernameLabel = new JLabel("Username");
        add(usernameLabel);
        usernameLabel.setBounds(
                300,
                0,
                ELE_WIDTH,
                ELE_HEIGHT);

        usernameText = new JTextField();
        add(usernameText);
        usernameText.setBounds(
                usernameLabel.getX(),
                usernameLabel.getY() + ELE_HEIGHT + MARGIN,
                ELE_WIDTH,
                ELE_HEIGHT
        );

        passwordLabel = new JLabel("Password");
        add(passwordLabel);
        passwordLabel.setBounds(
                usernameText.getX(),
                usernameText.getY() + ELE_HEIGHT + MARGIN,
                ELE_WIDTH,
                ELE_HEIGHT
        );

        passwordText = new JTextField();
        add(passwordText);
        passwordText.setBounds(
                passwordLabel.getX(),
                passwordLabel.getY() + ELE_HEIGHT + MARGIN,
                ELE_WIDTH,
                ELE_HEIGHT
        );

        loginButton = new JButton("Login");
        add(loginButton);
        loginButton.setBounds(
                passwordText.getX(),
                passwordText.getY() + ELE_HEIGHT + 2 * MARGIN,
                ELE_WIDTH,
                ELE_HEIGHT);

        loginButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login();
            }
        });
    }

    private void login(){
        String username = usernameText.getText();
        String password = passwordText.getText();

        if (username.trim().isEmpty() || password.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Username or password not empty!");
            return;
        }

        if (loginController.login(username, password)){
            JOptionPane.showMessageDialog(this, "Login success!");
        } else {
            logger.info("Login fail");
            JOptionPane.showMessageDialog(this, "Username or password is wrong!");
        }
    }
}
