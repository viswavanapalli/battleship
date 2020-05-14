package com.game.entity.grid;

import com.game.entity.Location;
import com.game.enums.Shot;

public class OpponentGrid extends Grid{

    protected int size;

    protected Shot[][] arena;

    public OpponentGrid(int size) {
        super(size);
        this.size = super.size;
        arena = new Shot[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                arena[i][j] = Shot.BLANK;
            }
        }
    }

    public boolean validateShot(Location location){
        if(super.validateLocation(location)){
            if(!arena[location.getX()][location.getY()].equals(Shot.BLANK)){
                return true;
            }
        }
        return false;
    }

    public void setShot(Location location, Shot shot){

    }

}
