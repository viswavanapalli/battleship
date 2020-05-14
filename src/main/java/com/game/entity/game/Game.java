package com.game.entity.game;

import com.game.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private int id;
    private List<Player> players;
    private GameStatus gameStatus;
    private static int gameCounter;

    Game(List<Player> players){

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
