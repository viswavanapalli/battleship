package com.game.service;

import com.game.entity.Grid;
import com.game.entity.Player;
import com.game.entity.ship.Ship;
import com.game.model.CreateShipModel;
import com.game.model.TargetModel;

import java.lang.annotation.Target;

public interface PlayerService {
    public Player savePlayer(Player player);

    public Player updatePlayer(Player player);

    public Player addShip(CreateShipModel createShipModel);

    public void target(TargetModel targetModel);

    public boolean validateShipLocation(Ship ship, int size);

    public boolean validateCollision(Ship ship, Grid grid);

    public boolean updateGridAfterAddShip(Ship ship, Grid grid);
}
