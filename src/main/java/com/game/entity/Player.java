package com.game.entity;

import com.game.entity.Grid;
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
    private Grid grid;
    private List<Ship> ships;

    public Player(List<Ship> ships){

    }
}
