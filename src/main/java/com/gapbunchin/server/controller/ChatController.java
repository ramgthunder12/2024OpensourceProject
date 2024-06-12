package com.gapbunchin.server.controller;

import com.gapbunchin.server.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
<<<<<<< HEAD
=======
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
>>>>>>> 8374a98 (GameController, service 수정, Game, GameResult entity 생성)

@Controller
public class ChatController {

<<<<<<< HEAD
    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        return new Message(HtmlUtils.htmlEscape(message.getAuthor()), HtmlUtils.htmlEscape(message.getMessage()));
    }
}

=======
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message send(Message message) {
        logger.debug("Received message: {}", message);
        return new Message(HtmlUtils.htmlEscape(message.getAuthor()), HtmlUtils.htmlEscape(message.getMessage()));
    }
}
>>>>>>> 8374a98 (GameController, service 수정, Game, GameResult entity 생성)
