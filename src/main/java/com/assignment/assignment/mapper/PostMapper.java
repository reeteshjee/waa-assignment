package com.assignment.assignment.mapper;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.PostDto;
public class PostMapper {
    public static PostDto toPostDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setUserId(post.getUser().getId()); // Ensure userId is set
        return dto;
    }

    public static Post toPost(PostDto dto, User user) { // Accept User as parameter
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setUser(user); // Set the user reference
        return post;
    }
}