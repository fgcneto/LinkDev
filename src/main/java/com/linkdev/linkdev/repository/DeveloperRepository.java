package com.linkdev.linkdev.repository;

import com.linkdev.linkdev.models.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer findDeveloperByName(String name);
    Developer findDeveloperByCpf(String cpf);
}
