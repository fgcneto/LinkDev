package com.linkdev.linkdev.repository;

import com.linkdev.linkdev.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
