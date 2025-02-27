package com.assignment.assignment.repo;

import com.assignment.assignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    // Add custom queries if necessary
}
