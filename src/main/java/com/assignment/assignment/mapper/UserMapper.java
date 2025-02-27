package com.assignment.assignment.mapper;

import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.UserDto;
import com.assignment.assignment.domain.Post;
import com.assignment.assignment.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDTO(User user) {
        return new UserDto(user.getId(), user.getName());
    }

    public User toEntity(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName());
    }

    public List<UserDto> toDTOList(List<User> users) {
        return users.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PostDto postToDTO(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getContent(),post.getUser().getId());
    }
}
