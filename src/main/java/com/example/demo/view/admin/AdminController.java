package com.example.demo.view.admin;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

public class AdminController {
    private final UserRepository repository;

    public AdminController(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(User user) {
        repository.create(user);
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
