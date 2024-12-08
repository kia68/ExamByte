package com.example.exambyte.domainLayer.service;

import com.example.exambyte.domainLayer.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User add(User user);

    void remove(User user);
}
