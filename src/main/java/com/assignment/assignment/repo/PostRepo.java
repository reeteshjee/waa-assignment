package com.assignment.assignment.repo;
import com.assignment.assignment.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepo {
    List<Post> posts = new ArrayList<>();

    public PostRepo(){
        posts.add(new Post(1,"The basics of Sping Boot","This article gives you the details about the basics of Spring Boot","Ritesh"));
        posts.add(new Post(2,"Why ReactJS is so popular","This article focuses on the strengths of ReactJS and why it is so popular in recent times","Ritesh"));
    }

    public List<Post> getall(){
        return posts;
    }

    public Post getbyid(int id){
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    public Post save(Post post) {
        posts.add(post);
        return post;
    }
}
