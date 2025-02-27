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

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostMapper postMapper;

    public List<PostDto> getAll() {
        List<Post> posts = postRepo.findAll();
        return postMapper.toDtoList(posts);
    }

    public PostDto getById(int id) {
        Post post = postRepo.findById(id).orElse(null);
        return post != null ? postMapper.toPostDto(post) : null;
    }

    public PostDto save(PostDto postDto) {
        User user = userRepo.findById(postDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setUser(user);  // Set the User entity in the Post

        // Save the post
        Post savedPost = postRepo.save(post);

        // Return PostDto with user details
        return new PostDto(savedPost.getId(), savedPost.getTitle(), savedPost.getContent(), savedPost.getUser().getId());
    }

    public List<PostDto> getpostsbyusers(Integer user_id) {
        List<Post> posts = postRepo.findByUserId(user_id);
        return postMapper.toDtoList(posts);
    }
}
