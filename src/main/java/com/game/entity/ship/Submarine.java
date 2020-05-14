package com.game.entity.ship;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;

public class Submarine extends Ship {

    public Submarine(Location location, Alignment alignment){
        super(ShipCategory.SUBMARINE, location, alignment);
    }

    public Submarine(){
        super(ShipCategory.SUBMARINE);
    }
}
