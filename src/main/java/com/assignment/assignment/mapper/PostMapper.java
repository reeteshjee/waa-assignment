package com.assignment.assignment.mapper;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostMapper {
    public PostDto toPostDto(Post post) {
        return new PostDto(post.getId(),post.getTitle(),post.getContent(),post.getAuthor());
    }

    public List<PostDto> toDtoList(List<Post> posts) {
        List<PostDto> dtos = new ArrayList<>();
        for(Post post : posts){
            dtos.add(this.toPostDto(post));
        }
        return dtos;
    }
}
