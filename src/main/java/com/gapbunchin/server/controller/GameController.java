package com.gapbunchin.server.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gapbunchin.server.entity.GameResult;
import com.gapbunchin.server.entity.User;
import com.gapbunchin.server.service.GameService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public void getAllUsers() {
    }

    @PostMapping("/{gameName}")
    public void selectGameRoom(@PathVariable String gameName, @RequestBody User user) {
    }

    @GetMapping("/ranking")
    public String getRanking() {
        return gameService.getRanking();
    }

    @PostMapping("/ranking")
    public void setRanking(@RequestBody GameResult gameResult) {
        gameService.addResult(gameResult);
    }
}
