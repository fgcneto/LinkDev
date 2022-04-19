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

//@Component
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

        User user = new User("admin@code.com", passwordEncoder.encode("password"),"Admin", "Super", true, "admin" );
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        user = new User("user@code.com", passwordEncoder.encode("password"),"User", "Super", true, "user" );
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

    }
}
