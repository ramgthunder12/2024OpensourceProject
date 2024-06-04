package com.gapbunchin.server.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat_room")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    // 다대다 관계로 사용자와 채팅방 관계를 설정합니다.
    @ManyToMany
    @JoinTable(
            name = "user_chat_room",
            joinColumns = @JoinColumn(name = "chat_room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter와 Setter 메서드는 생략
}
