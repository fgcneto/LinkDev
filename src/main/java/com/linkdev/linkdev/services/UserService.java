package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.UserRepository;
import com.linkdev.linkdev.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public void save(User user){
        userRepositoryJpa.save(user);
    }

}
