package com.gapbunchin.server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gapbunchin.server.entity.GameResult;
import com.gapbunchin.server.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    private List<GameResult> rank = new ArrayList<>();

    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 리스트를 반환하는 메소드
    public List<GameResult> getResults() {
        return rank;
    }

    // Result 객체를 리스트에 추가하는 메소드
    public void addResult(GameResult gameResult) {
        rank.add(new GameResult(gameResult.getNickname(), gameResult.getScore()));
    }

    // 리스트를 점수 순으로 정렬하는 메소드
    public void sortResultsByScore() {
        rank.sort(Comparator.comparingInt(GameResult::getScore).reversed());
    }

    // 리스트를 JSON 문자열로 변환하는 메소드
    public String convertResultsToJson() {
        try {
            sortResultsByScore();
            return objectMapper.writeValueAsString(rank);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getRanking() {
        return convertResultsToJson();
    }

}
