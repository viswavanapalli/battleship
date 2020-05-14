package com.game.factory;

import com.game.entity.ship.*;
import com.game.enums.ShipCategory;

public class ShipFactory {
    public Ship getShip(ShipCategory shipCategory){
        switch(shipCategory){
            case CARRIER:
                return new Carrier();
            case BATTLESHIP:
                return new Battleship();
            case CRUISER:
                return new Cruiser();
            case SUBMARINE:
                return new Submarine();
            case DESTROYER:
                return new Destroyer();
        }
        return null;
    }
}
