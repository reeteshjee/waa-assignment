package com.assignment.assignment.controller;

import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.dto.UserDto;
import com.assignment.assignment.service.PostService;
import com.assignment.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping()
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUserId(@PathVariable int id) {
        return userService.getPostsByUserId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted successfully with all associated posts and comments";
    }

    @GetMapping("/more-than/{n}/posts")
    public List<UserDto> getUsersWithMoreThanNPosts(@PathVariable int n) {
        return userService.getUsersWithMoreThanNPosts(n);
    }

}