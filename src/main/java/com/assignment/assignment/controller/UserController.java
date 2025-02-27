package com.assignment.assignment.controller;

import com.assignment.assignment.dto.UserDto;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Retrieve all users
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    // Retrieve a user by ID
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    // Create a new user
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }

    // Retrieve posts of a user by user ID
    @GetMapping("/{id}/posts")
    public List<PostDto> getUserPosts(@PathVariable Integer id) {
        return userService.getUserPosts(id);
    }
}
