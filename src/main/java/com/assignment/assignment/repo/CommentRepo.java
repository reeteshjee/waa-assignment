package com.assignment.assignment.repo;

import com.assignment.assignment.domain.Comment;
import com.assignment.assignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    // Add custom queries if necessary
}
