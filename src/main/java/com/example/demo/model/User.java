package com.example.demo.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String address;
    private int age;
    private final int role;

    public static final int ROLE_ADMIN = 1;
    public static final int ROLE_MANAGER = 2;
    public static final int ROLE_EMPLOYEE = 3;

    public User(int role) {
        assert (role > 0 && role < 4) : "Role is not valid";
        this.role = role;
    }

    public User(int role, String username, String password, String email, String name, String address, int age) {
        assert (role > 0 && role < 4) : "Role is not valid";
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin(){
        return role == ROLE_ADMIN;
    }

    public boolean isEmployee() {
        return role == ROLE_EMPLOYEE;
    }

    public boolean isManager() {
        return role == ROLE_MANAGER;
    }

    public int getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }
}
