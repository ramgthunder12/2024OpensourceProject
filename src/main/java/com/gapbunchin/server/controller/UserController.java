package com.gapbunchin.server.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.gapbunchin.server.entity.User;
import com.gapbunchin.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {

        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = userService.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/login/{nickname}")
    public ResponseEntity<User> getUserByNickname(@PathVariable String nickname) {
        Optional<User> user = userService.findByNickname(nickname);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User userDetails) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();
        user.setNickname(userDetails.getNickname());
        user.setGender(userDetails.getGender());
        user.setGenderPublic(userDetails.getGenderPublic());
        user.setAge(userDetails.getAge());
        user.setLocation(userDetails.getLocation());

        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    @PutMapping("/location/{id}")
    public ResponseEntity<User> updateUserLocation(@PathVariable Integer id, @RequestBody User userDetails) {
        Optional<User> userOptional = userService.findById(id);
        if (!userOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();
        user.setLocation(userDetails.getLocation());

        User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if (!userService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

