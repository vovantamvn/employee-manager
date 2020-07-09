package com.example.demo.view.admin;

import com.example.demo.model.User;

import javax.swing.*;
import java.util.List;

public class UserAdapter extends AbstractListModel<String> {
    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    @Override
    public int getSize() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String getElementAt(int i) {
        User user = users.get(i);
        return String.format("%-20s %-20s %-20s %-20s %d",
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getAddress(),
                user.getAge());
    }
}
