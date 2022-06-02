package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Role;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.RoleRepository;
import com.linkdev.linkdev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");



        User user = new User(true,  "admin", passwordEncoder.encode("password"));
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        user = new User(true, "user" , passwordEncoder.encode("password"));
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

    }
}
