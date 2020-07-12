package com.example.demo.repository;

import java.util.List;

public interface Repository<T> {
    public T create(T obj);
    public boolean update(int id, T obj);
    public T findById(int key);
    public boolean deleteById(int key);
    public List<T> getAll();
}
