package com.linkdev.linkdev.services;

import com.linkdev.linkdev.models.Company;
import com.linkdev.linkdev.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company add(Company company) {
        return companyRepository.save(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

     public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }
}
