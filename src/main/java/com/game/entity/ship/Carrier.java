package com.game.entity.ship;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;

public class Carrier extends Ship {

    public Carrier(Location location, Alignment alignment){
        super(ShipCategory.CARRIER, location, alignment);
    }

    public Carrier(){
        super(ShipCategory.CARRIER);
    }
}
