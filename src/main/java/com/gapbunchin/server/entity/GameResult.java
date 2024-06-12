package com.gapbunchin.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameResult {
    public GameResult(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
    }
    public GameResult() {

    }
    private String nickname;
    private int score;
    @Id
    private Long id;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
