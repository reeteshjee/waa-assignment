package com.assignment.assignment.repo;

import com.assignment.assignment.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
