package com.game.entity;

import com.game.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private Player player1;
    private Player player2;
    private GameStatus gameStatus;
    private Player winner;
    private int turnId;

    Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        turnId = player1.getId();
    }

    public void setup(){

    }

    public void startGame(){

    }


    public void endGame(){

    }

    public void pauseGame(){

    }

}
