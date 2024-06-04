package com.gapbunchin.server.entity;

public class ChatMessage {

    private String sender;
    private String content;
    private MessageType type;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    // Getters and Setters
}
