package com.gapbunchin.server.controller;

import com.gapbunchin.server.dto.ChatRoomRequest;
import com.gapbunchin.server.entity.ChatRoom;
import com.gapbunchin.server.entity.User;
import com.gapbunchin.server.repository.ChatRoomRepository;
import com.gapbunchin.server.repository.UserRepository;
import com.gapbunchin.server.service.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ChattingController {

    @Autowired
    private ChattingService chattingService;


    // Create a new ChatRoom
    @PostMapping("/chat-rooms")
    public ResponseEntity<ChatRoom> createChatRoom(@RequestBody ChatRoom chatRoom) {
//TODO 코드 확인하기

        ChatRoom savedChatRoom = chattingService.save(chatRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedChatRoom);
    }


//
//    // Get all ChatRooms
//    @GetMapping
//    public List<ChatRoom> getAllChatRooms() {
//        return chatRoomRepository.findAll();
//    }
//
//    // Get a ChatRoom by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Integer id) {
//        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(id);
//        if (chatRoomOptional.isPresent()) {
//            return ResponseEntity.ok(chatRoomOptional.get());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    // Update a ChatRoom
//    @PutMapping("/{id}")
//    public ResponseEntity<ChatRoom> updateChatRoom(@PathVariable Integer id, @RequestBody ChatRoomRequest chatRoomRequest) {
//        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(id);
//        if (!chatRoomOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//        ChatRoom chatRoom = chatRoomOptional.get();
//
//        Optional<User> userOptional = userRepository.findById(chatRoomRequest.getUserId());
//        if (!userOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        User user = userOptional.get();
//
//        chatRoom.setUserId(user);
//        chatRoom.setContent(chatRoomRequest.getContent());
//        chatRoom.setRoomId(chatRoomRequest.getRoomId());
//
//        ChatRoom updatedChatRoom = chatRoomRepository.save(chatRoom);
//        return ResponseEntity.ok(updatedChatRoom);
//    }
//
//    // Delete a ChatRoom
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteChatRoom(@PathVariable Integer id) {
//        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById(id);
//        if (!chatRoomOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//        chatRoomRepository.delete(chatRoomOptional.get());
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
}
