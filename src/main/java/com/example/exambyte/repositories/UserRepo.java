package com.example.exambyte.repositories;

import com.example.exambyte.test.Test;
import com.example.exambyte.users.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {

    List<User> userList = new ArrayList<>();

    public List<User> findAll() {
        return userList;
    }
}
