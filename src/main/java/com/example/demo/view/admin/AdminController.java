package com.example.demo.view.admin;

import com.example.demo.model.User;
import com.example.demo.repository.Repository;

import java.util.List;

public class AdminController {
    private final Repository<User> repository;

    public AdminController(Repository<User> repository) {
        this.repository = repository;
    }

    public boolean createUser(User user) {
        User result = repository.create(user);
        return result != null;
    }

    public void updateUser(int id, User user) {
        repository.update(id, user);
    }

    public boolean deleteUser(int id) {
        return repository.deleteById(id);
    }

    public List<User> getAllUser() {
        return repository.getAll();
    }
}
