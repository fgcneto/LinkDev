package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Role;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.RoleRepository;
import com.linkdev.linkdev.repository.UserRepository;
import com.linkdev.linkdev.repository.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    private UserRepositoryJpa userRepositoryJpa;
    private RoleRepository roleRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public void save(User user){
        userRepositoryJpa.save(user);
    }
}
