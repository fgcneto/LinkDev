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

    @Autowired
    public void setUserRepositoryJpa(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public User getById(Long id){
        return userRepositoryJpa.getById(id);
    }

    public void save(User user){
        userRepositoryJpa.save(user);
    }

    public void delete(Long id){
        userRepositoryJpa.deleteById(id);
    }
}
