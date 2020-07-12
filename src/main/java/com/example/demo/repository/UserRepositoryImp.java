package com.example.demo.repository;

import com.example.demo.model.User;
import com.example.demo.utils.SQLServerConnectionProvideImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImp implements Repository<User> {
    private Connection connection;

    public UserRepositoryImp() {
        SQLServerConnectionProvideImp connectionProvideImp = new SQLServerConnectionProvideImp();
        connection = connectionProvideImp.getConnection();
        
        if (connection == null) {
            throw new RuntimeException("SQL connection not must be null!");
        }
    }

    public UserRepositoryImp(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User create(User obj) {
        //INSERT users values('username', 'password',
        // 'role', name, age, gender, dob, deparment, adress, email);
        String query = String.format("INSERT users VALUES('%s', '%s', %d, N'%s', %d, %d, '%s', N'%s', N'%s', '%s')",
                obj.getUsername(),
                obj.getPassword(),
                obj.getRole(),
                obj.getName(),
                obj.getAge(),
                obj.getGender(),
                obj.getDob().toString(),
                obj.getDepartment(),
                obj.getAddress(),
                obj.getEmail());

        try(Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        
        //System.out.println(query);

        return obj;
    }

    @Override
    public boolean update(int id, User obj) {
        String query = String.format("UPDATE users\n" +
                "SET username = '%s',\n" +
                "    password = '%s',\n" +
                "    role = %d,\n" +
                "    name = N'%s',\n" +
                "    age = %d,\n" +
                "    gender = %d,\n" +
                "    dob = '%s',\n" +
                "    department = N'%s',\n" +
                "    address = N'%s',\n" +
                "    email = '%s'\n" +
                "WHERE id = %d;",
                obj.getUsername(),
                obj.getPassword(),
                obj.getRole(),
                obj.getName(),
                obj.getAge(),
                obj.getGender(),
                obj.getDob().toString(),
                obj.getDepartment(),
                obj.getAddress(),
                obj.getEmail(),
                id);

        try(Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query) > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public User findById(int key) {
        String query = String.format("SELECT id, username, password, role, name, age,"
                +" gender, dob, department, address, email FROM users where id = %d;", key);

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            User user = new User();

            user.setId(resultSet.getInt(1));
            user.setUsername(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            user.setRole(resultSet.getInt(4));
            user.setName(resultSet.getString(5));
            user.setAge(resultSet.getInt(6));
            user.setGender(resultSet.getByte(7));
            user.setDob(LocalDate.parse(resultSet.getString(8)));
            user.setDepartment(resultSet.getString(9));
            user.setAddress(resultSet.getString(10));
            user.setEmail(resultSet.getString(11));

            return user;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int key) {
        String query = String.format("DELETE users WHERE id = %d;", key);

        try(Statement statement = connection.createStatement()) {
            return statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> getAll() {
        String query = String.format("SELECT id, username, password, role, name, age,"
                +" gender, dob, department, address, email FROM users;");

        List<User> users = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                try {
                    User user = new User();
                    user.setId(resultSet.getInt(1));
                    user.setUsername(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setRole(resultSet.getInt(4));
                    user.setName(resultSet.getString(5));
                    user.setAge(resultSet.getInt(6));
                    user.setGender(resultSet.getByte(7));
                    user.setDob(LocalDate.parse(resultSet.getString(8)));
                    user.setDepartment(resultSet.getString(9));
                    user.setAddress(resultSet.getString(10));
                    user.setEmail(resultSet.getString(11));

                    users.add(user);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        return users;
    }
}
