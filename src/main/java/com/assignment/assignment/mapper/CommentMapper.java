package com.assignment.assignment.mapper;

import com.assignment.assignment.domain.Comment;
import com.assignment.assignment.dto.CommentDto;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        return dto;
    }

    public static Comment toComment(CommentDto dto) {
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setName(dto.getName());
        return comment;
    }
}
