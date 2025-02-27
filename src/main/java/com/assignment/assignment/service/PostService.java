package com.assignment.assignment.service;

import com.assignment.assignment.domain.Post;
import com.assignment.assignment.dto.PostDto;
import com.assignment.assignment.mapper.PostMapper;
import com.assignment.assignment.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    PostMapper postMapper;

    public List<PostDto> getall(){
        List<Post> posts = postRepo.findAll();
        return postMapper.toDtoList(posts);
    }

    public PostDto getbyid(int id){
        Post post = postRepo.findById(id).orElse(null);
        return postMapper.toPostDto(post);
    }

    public PostDto save(Post post) {
        Post p = postRepo.save(post);
        return postMapper.toPostDto(p);
    }

}



