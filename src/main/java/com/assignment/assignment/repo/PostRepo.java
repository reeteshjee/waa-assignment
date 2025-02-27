package com.assignment.assignment.repo;

import com.assignment.assignment.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(Integer userId);
}
