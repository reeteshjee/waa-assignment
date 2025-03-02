package com.assignment.assignment.repo;

import com.assignment.assignment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :postCount")
    List<User> findUsersWithMoreThanNPosts(@Param("postCount") int postCount);
}
