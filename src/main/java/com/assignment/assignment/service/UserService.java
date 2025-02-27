package com.assignment.assignment.service;

import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.UserDto;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.mapper.UserMapper;
import com.assignment.assignment.repo.UserRepo;
import com.assignment.assignment.repo.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final UserMapper userMapper;

    public UserService(UserRepo userRepo, PostRepo postRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers() {
        return userMapper.toDTOList(userRepo.findAll());
    }

    public UserDto getUserById(Integer id) {
        return userRepo.findById(id).map(userMapper::toDTO).orElse(null);
    }

    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User savedUser = userRepo.save(user);
        return userMapper.toDTO(savedUser);
    }

    public List<PostDto> getUserPosts(Integer userId) {
        return postRepo.findAll().stream()
                .filter(post -> post.getAuthor().equals(userId))
                .map(userMapper::postToDTO)
                .toList();
    }
}
