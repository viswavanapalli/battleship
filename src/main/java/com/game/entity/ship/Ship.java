package com.game.entity.ship;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Ship {

    private int shipId;
    private ShipCategory shipCategory;
    private Location location;
    private Alignment alignment;

    public Ship(ShipCategory shipCategory, Location location, Alignment alignment){
        this.shipCategory = shipCategory;
        this.location = location;
        this.alignment = alignment;
    }

    public Ship(ShipCategory shipCategory){
        this.shipCategory = shipCategory;
    }

}
