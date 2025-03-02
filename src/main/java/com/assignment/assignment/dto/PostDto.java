package com.assignment.assignment.dto;

public class PostDto {
    private int id;
    private String title;
    private String content;
    private int userId;  // Add userId field

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {  // Getter for userId
        return userId;
    }

    public void setUserId(int userId) {  // Setter for userId
        this.userId = userId;
    }
}
