package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.*;
import com.linkdev.linkdev.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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

        Developer devNeto = new Developer("fgcneto", passwordEncoder.encode("password"),
                "Neto","Da Silva", "12345678902", "05-05-1981",
                "ig@ig.com.br","8888-8888");
        devNeto.setRoles(Arrays.asList(userRoleDeveloper));
        developerRepository.save(devNeto);

        Developer devClara = new Developer("clara", passwordEncoder.encode("password"),
                "Clara","Da Silva", "12345678902", "05-05-2000",
                "ig@ig.com.br","8888-8888");
        devClara.setRoles(Arrays.asList(userRoleDeveloper));
        developerRepository.save(devClara);

        Company companyMicrosoft = new Company("loginmicrosft", passwordEncoder.encode("password"), "Microsoft",
                "12345679", "contato@microsoft.com", "www.microsoft.com",
                "@microsoft");
        companyMicrosoft.setRoles(Arrays.asList(userRoleCompany));
        companyRepository.save(companyMicrosoft);

        Company companyGoogle = new Company("google", passwordEncoder.encode("password"), "Google",
                "12345679", "contato@google.com", "www.google.com",
                "@google");
        companyGoogle.setRoles(Arrays.asList(userRoleCompany));
        companyRepository.save(companyGoogle);

        JobOpportunity jobOpportunity = new JobOpportunity(
                "Vaga Backend Python", "CLT",
                "Densenvolvedor Python usando Django", companyGoogle);
        jobOpportunityRepository.save(jobOpportunity);

        JobOpportunity jobOpportunity2 = new JobOpportunity(
                "Vaga Backend Java", "CLT",
                "Densenvolvedor Java usando Spring Boot", companyMicrosoft);
        jobOpportunityRepository.save(jobOpportunity2);

    }
}
