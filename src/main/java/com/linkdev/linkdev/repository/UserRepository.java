package com.linkdev.linkdev.repository;

import com.linkdev.linkdev.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
