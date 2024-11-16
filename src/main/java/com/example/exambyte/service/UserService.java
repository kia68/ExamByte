package com.example.exambyte.service;

import com.example.exambyte.users.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    private void addUser(User user) {
        userList.add(user);
    }

    private void deleteUser(User user) {
        userList.remove(user);
    }


}
