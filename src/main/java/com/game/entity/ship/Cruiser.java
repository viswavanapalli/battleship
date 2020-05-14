package com.game.entity.ship;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;

public class Cruiser extends Ship {

    public Cruiser(Location location, Alignment alignment){
        super(ShipCategory.CRUISER, location, alignment);
    }

    public Cruiser(){
        super(ShipCategory.CRUISER);
    }
}
