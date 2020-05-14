package com.game.entity.ship;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;

public class Destroyer extends Ship {

    public Destroyer(Location location, Alignment alignment){
        super(ShipCategory.DESTROYER, location, alignment);
    }

    public Destroyer(){
        super(ShipCategory.DESTROYER);
    }
}
