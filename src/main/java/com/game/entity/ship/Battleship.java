package com.game.entity.ship;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;

public class Battleship extends Ship {

    public Battleship(Location location, Alignment alignment){
        super(ShipCategory.BATTLESHIP, location, alignment);
    }

    public Battleship(){
        super(ShipCategory.BATTLESHIP);
    }

}
