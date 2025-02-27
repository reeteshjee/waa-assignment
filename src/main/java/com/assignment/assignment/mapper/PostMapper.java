package com.assignment.assignment.mapper;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {

    @Autowired
    private UserRepo userRepo;

    public PostDto toPostDto(Post post) {
        User user = post.getUser();  // Retrieve the user associated with the post
        Integer userId = user != null ? user.getId() : null;
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), userId);
    }

    public PostDto toPostDtoWithUser(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getContent(), post.getUser().getId());
    }

    public List<PostDto> toDtoList(List<Post> posts) {
        List<PostDto> dtos = new ArrayList<>();
        for (Post post : posts) {
            dtos.add(this.toPostDto(post));
        }
        return dtos;
    }
}
