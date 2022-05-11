package com.linkdev.linkdev.repository;

import com.linkdev.linkdev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {

}
