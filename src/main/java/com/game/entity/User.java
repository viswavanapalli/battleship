package com.game.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int level;

    private static int playerCounter;

    public User(String name, int level){
        this.name = name;
        this.level = level;
    }
}
