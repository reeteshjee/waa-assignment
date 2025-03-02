package com.assignment.assignment.controller;

import com.assignment.assignment.dto.CommentDto;
import com.assignment.assignment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/comments")
    public CommentDto addComment(@PathVariable int postId, @RequestBody CommentDto commentDto) {
        return commentService.addComment(postId, commentDto);
    }
}
