package com.example.demo.repository;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements Repository<User> {
    private static Map<Integer, User> userMap = new HashMap<Integer, User>();
    private static int id = 1;

    static {
        User user = new User(1, "vovantam", "123", "vovantam.dev");
        userMap.put(id++, user);
    }

    public User create(User obj) {
        obj.setId(++id);
        userMap.put(id, obj);
        return obj;
    }

    public User update(int id, User obj) {
        obj.setId(id);
        userMap.put(id, obj);
        return obj;
    }

    public User findById(int key) {
        return userMap.get(key);
    }

    public boolean deleteById(int key) {
        if (userMap.containsKey(key)){
            userMap.remove(key);
            return true;
        }

        return false;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.addAll(userMap.values());
        return users;
    }
}
