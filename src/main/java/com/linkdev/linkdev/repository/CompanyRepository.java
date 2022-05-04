package com.linkdev.linkdev.repository;

import com.linkdev.linkdev.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findCompanyByName(String nome);
    Company findCompanyByCnpj(String cnpj);
}
