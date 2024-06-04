package com.gapbunchin.server.service;

import com.gapbunchin.server.entity.ChatRoom;
import com.gapbunchin.server.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChattingService {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }

    public Optional<ChatRoom> findById(Integer id) {
        return chatRoomRepository.findById(id);
    }

    public ChatRoom save(ChatRoom chatRoom) {
        return chatRoomRepository.save(chatRoom);
    }

    public void deleteById(Integer id) {
        chatRoomRepository.deleteById(id);
    }
}
