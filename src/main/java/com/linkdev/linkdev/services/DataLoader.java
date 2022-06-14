package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.models.Developer;
import com.linkdev.linkdev.models.Role;
import com.linkdev.linkdev.models.User;
import com.linkdev.linkdev.repository.CompanyRepository;
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

    @Autowired
    CompanyRepository companyRepository;


    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("COMPANY"));
        roleRepository.save(new Role("DEVELOPER"));

        Role userRoleCompany = roleRepository.findByRole("COMPANY");
        Role userRoleDeveloper = roleRepository.findByRole("DEVELOPER");


        User userDev = new User("dev", passwordEncoder.encode("password"));
        userDev.setRoles(Arrays.asList(userRoleDeveloper));
        userRepository.save(userDev);

        User userCompany = new User("company" , passwordEncoder.encode("password"));
        userCompany.setRoles(Arrays.asList(userRoleCompany));
        userRepository.save(userCompany);

        Developer dev = new Developer("fgcneto", "password",
                "Francisco","Da Silva", "12345678902", "05-05-1981",
                "ig@ig.com.br","8888-8888");
        dev.setUser(userDev);
        developerRepository.save(dev);

        Company company = new Company("microsoft", "password", "Microsoft",
                "12345679", "contato@microsoft.com", "www.microsoft.com",
                "@micrsoft");
        company.setUser(userCompany);
        companyRepository.save(company);

    }
}
