package com.example.homemade.persistence.repositories;

import com.example.homemade.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
