package com.example.exambyte.applicationService;

import com.example.exambyte.domainLayer.serviceRepository.UserRepository;
import com.example.exambyte.domainLayer.model.User;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    private void addUser(User user) {
        userRepo.add(user);
    }

    private void deleteUser(User user) {
        userRepo.remove(user);
    }


}
