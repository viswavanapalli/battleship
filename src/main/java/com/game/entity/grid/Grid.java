package com.game.entity.grid;

import com.game.entity.Location;
import com.game.entity.ship.Ship;
import com.game.enums.Alignment;

public class Grid {

    protected int size;

    public Grid(int size){
        this.size = size;
    }

    public boolean validateLocation(Location location){
        if(location.getX()>=0
                && location.getX()<size
                && location.getY()>=0
                && location.getY()<size){
            return true;
        } else{
            return false;
        }
    }

}
