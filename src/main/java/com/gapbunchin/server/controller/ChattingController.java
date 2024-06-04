package com.gapbunchin.server.controller;

import com.gapbunchin.server.entity.ChatRoom;
import com.gapbunchin.server.service.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat-rooms")
public class ChattingController {

    @Autowired
    private ChattingService chatRoomService;

    @GetMapping
    public List<ChatRoom> getAllChatRooms() {
        return chatRoomService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Integer id) {
        Optional<ChatRoom> chatRoom = chatRoomService.findById(id);
        return chatRoom.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChatRoom createChatRoom(@RequestBody ChatRoom chatRoom) {
        return chatRoomService.save(chatRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatRoom> updateChatRoom(@PathVariable Integer id, @RequestBody ChatRoom chatRoomDetails) {
        Optional<ChatRoom> chatRoomOptional = chatRoomService.findById(id);
        if (!chatRoomOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ChatRoom chatRoom = chatRoomOptional.get();
        chatRoom.setName(chatRoomDetails.getName());

        ChatRoom updatedChatRoom = chatRoomService.save(chatRoom);
        return ResponseEntity.ok(updatedChatRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Integer id) {
        if (!chatRoomService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        chatRoomService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
