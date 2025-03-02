package com.assignment.assignment.controller;


import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping()
    public PostDto createPost(@RequestBody PostDto postDto) {
        return postService.createPost(postDto);
    }

    @GetMapping("/search")
    public List<PostDto> getPostsByTitle(@RequestParam String title) {
        return postService.getPostsByTitle(title);
    }

}