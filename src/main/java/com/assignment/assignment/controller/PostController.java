package com.assignment.assignment.controller;

import com.assignment.assignment.domain.Post;
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
    PostService postService;

    @GetMapping
    public List<PostDto> getall(){
        return postService.getall();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable int id) {
        return postService.getbyid(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto save(@RequestBody Post post) {
        return postService.save(post);
    }

}