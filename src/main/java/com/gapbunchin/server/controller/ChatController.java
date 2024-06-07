package com.gapbunchin.server.controller;

import com.gapbunchin.server.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        return new Message(HtmlUtils.htmlEscape(message.getAuthor()), HtmlUtils.htmlEscape(message.getMessage()));
    }
}

