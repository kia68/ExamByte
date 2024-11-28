package com.example.exambyte.persistence.repositories;

import com.example.exambyte.domainLayer.service.UserRepository;
import com.example.exambyte.domainLayer.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepository {

    List<User> userList = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return userList;
    }


    @Override
    public User add(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public void remove(User user) {
        userList.remove(user);
    }

}
