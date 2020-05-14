package com.game.entity.game;

import com.game.entity.grid.Grid;
import com.game.entity.ship.Ship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int id;
    private int userId;
    private int gameId;
    private Grid currentGrid;
    private Grid opponentGrid;
    private List<Ship> ships;

    public Player(List<Ship> ships){

    }
}
