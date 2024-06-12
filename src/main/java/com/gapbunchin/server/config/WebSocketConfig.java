package com.gapbunchin.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
<<<<<<< HEAD
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
=======
        registry.addEndpoint("/api/ws")
                .setAllowedOriginPatterns("*")
                .withSockJS(); // withSockJS()는 SockJS를 사용할 때만 필요합니다. 그렇지 않으면 제거할 수 있습니다.
>>>>>>> 8374a98 (GameController, service 수정, Game, GameResult entity 생성)
    }
}
