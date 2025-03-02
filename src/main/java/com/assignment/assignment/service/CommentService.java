package com.assignment.assignment.service;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.domain.Comment;
import com.assignment.assignment.dto.CommentDto;
import com.assignment.assignment.repo.PostRepo;
import com.assignment.assignment.repo.CommentRepo;
import com.assignment.assignment.mapper.CommentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    public CommentDto addComment(int postId, CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setPost(post);
        comment = commentRepo.save(comment);
        return CommentMapper.toCommentDto(comment);
    }
}