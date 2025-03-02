package com.assignment.assignment.service;

import com.assignment.assignment.domain.User;
import com.assignment.assignment.domain.Post;
import com.assignment.assignment.repo.UserRepo;
import com.assignment.assignment.repo.PostRepo;
import com.assignment.assignment.dto.UserDto;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.mapper.UserMapper;
import com.assignment.assignment.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }

    public UserDto getUserById(int id) {
        return userRepo.findById(id).map(UserMapper::toUserDto).orElse(null);
    }

    public UserDto createUser(UserDto userDto) {
        User user = userRepo.save(UserMapper.toUser(userDto));
        return UserMapper.toUserDto(user);
    }

    public List<PostDto> getPostsByUserId(int userId) {
        return postRepo.findByUserId(userId).stream().map(PostMapper::toPostDto).collect(Collectors.toList());
    }

    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }

    public List<UserDto> getUsersWithMoreThanNPosts(int postCount) {
        return userRepo.findUsersWithMoreThanNPosts(postCount)
                .stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

}
