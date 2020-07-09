package com.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnectionProvideImp implements ConnectionProvide {
    private String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=db_emplyee;user=sa;password=Abcd@1234";

    @Override
    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(connectionUrl);
            return connection;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
