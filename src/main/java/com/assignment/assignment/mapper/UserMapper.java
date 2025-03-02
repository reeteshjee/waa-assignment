package com.assignment.assignment.mapper;

import com.assignment.assignment.domain.User;
import com.assignment.assignment.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());

        // Handle null posts to avoid NullPointerException
        if (user.getPosts() != null) {
            dto.setPosts(user.getPosts().stream().map(PostMapper::toPostDto).collect(Collectors.toList()));
        } else {
            dto.setPosts(Collections.emptyList()); // Set an empty list instead of null
        }

        return dto;
    }

    public static User toUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        return user;
    }
}
