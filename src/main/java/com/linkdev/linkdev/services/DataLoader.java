package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Developer;
import com.linkdev.linkdev.models.Role;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.DeveloperRepository;
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

    @Autowired
    DeveloperRepository developerRepository;


    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");



        User userAdmin = new User(true,  "admin", passwordEncoder.encode("password"));
        userAdmin.setRoles(Arrays.asList(adminRole));
        userRepository.save(userAdmin);

        User user = new User(true, "user" , passwordEncoder.encode("password"));
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        Developer dev = new Developer("Fulano", "Da Silva", "12345678902", "05-05-1981", "ig@ig.com.br","8888-8888", user);
        developerRepository.save(dev);

    }
}
