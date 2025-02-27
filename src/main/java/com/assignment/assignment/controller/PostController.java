package com.assignment.assignment.controller;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.domain.User;
import com.assignment.assignment.repo.UserRepo;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<PostDto> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable int id) {
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto save(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getbyusers(@PathVariable int id) {
        return postService.getpostsbyusers(id);
    }


}
