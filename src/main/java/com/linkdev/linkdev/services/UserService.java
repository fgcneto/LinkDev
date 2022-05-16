package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.UserRepository;
import com.linkdev.linkdev.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

}
