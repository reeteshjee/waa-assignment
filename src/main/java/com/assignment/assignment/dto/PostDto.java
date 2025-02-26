package com.assignment.assignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostDto {
    @JsonProperty
    int id;
    @JsonProperty
    String title;
    @JsonProperty
    String content;
    @JsonProperty
    String author;

    public PostDto(int id, String title, String content, String author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
