package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.*;
import com.linkdev.linkdev.repository.*;
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
    private DeveloperRepository developerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private JobOpportunityRepository jobOpportunityRepository;

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

        JobOpportunity jobOpportunity = new JobOpportunity(
                "Vaga Backend Python", "CLT",
                "Densenvolvedor Python usando Django");
        jobOpportunity.setCompany(company);
        jobOpportunityRepository.save(jobOpportunity);

        JobOpportunity jobOpportunity2 = new JobOpportunity(
                "Vaga Backend Java", "CLT",
                "Densenvolvedor Java usando Spring Boot");
        jobOpportunity2.setCompany(company);
        jobOpportunityRepository.save(jobOpportunity2);

    }
}
