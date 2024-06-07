package com.gapbunchin.server.entity;

public class Message {
    private String author;
    private String message;

    public Message() {}

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }

    // Getters and Setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
