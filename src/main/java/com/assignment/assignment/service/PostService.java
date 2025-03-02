package com.assignment.assignment.service;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.mapper.PostMapper;
import com.assignment.assignment.repo.PostRepo;
import com.assignment.assignment.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;  // Inject UserRepository

    public List<PostDto> getAllPosts() {
        return postRepo.findAll().stream().map(PostMapper::toPostDto).collect(Collectors.toList());
    }

    public PostDto getPostById(int id) {
        return postRepo.findById(id).map(PostMapper::toPostDto).orElse(null);
    }

    public PostDto createPost(PostDto postDto) {
        if (postDto.getUserId() <= 0) {  // Validate userId
            throw new IllegalArgumentException("Invalid user ID: " + postDto.getUserId());
        }

        User user = userRepo.findById(postDto.getUserId()).orElseThrow(() ->
                new IllegalArgumentException("User not found with ID: " + postDto.getUserId()));

        Post post = PostMapper.toPost(postDto, user); // Pass user to mapper
        post = postRepo.save(post); // Save post
        return PostMapper.toPostDto(post); // Return saved post
    }

    public List<PostDto> getPostsByTitle(String title) {
        return postRepo.findPostsByTitle(title)
                .stream()
                .map(PostMapper::toPostDto)
                .collect(Collectors.toList());
    }
}