package com.game.entity.grid;

import com.game.entity.Location;
import com.game.entity.ship.Ship;
import com.game.enums.Alignment;

public class HomeGrid extends Grid {

    protected int size;

    protected boolean[][] arena;

    public HomeGrid(int size) {
        super(size);
        this.size = super.size;
        this.arena = new boolean[size][size];
    }

    public boolean addShip(Ship ship){
        if(validateShipLocation(ship) && validateCollision(ship)){
            updateArenaAfterAddShip(ship);
            return true;
        } else {
            return false;
        }
    }

    public boolean validateShipLocation(Ship ship){
        Location startLocation = ship.getLocation();
        Location endLocation = null;
        if(ship.getAlignment().equals(Alignment.HORIZONTAL)){
            endLocation = new Location(ship.getLocation().getX()+ ship.getShipCategory().getLength(), ship.getLocation().getY());
        } else if(ship.getAlignment().equals(Alignment.VERTICAL)){
            endLocation = new Location(ship.getLocation().getX(), ship.getLocation().getY() + ship.getShipCategory().getLength());
        }

        if(super.validateLocation(startLocation) && super.validateLocation(endLocation)){
             return true;
        }
        return false;
    }

    public boolean validateCollision(Ship ship){
        int dx = ship.getAlignment().equals(Alignment.HORIZONTAL)? ship.getShipCategory().getLength() : 0;
        int dy = ship.getAlignment().equals(Alignment.VERTICAL)? 0 : ship.getShipCategory().getLength();
        for(int i=ship.getLocation().getX(); i<ship.getLocation().getX()+dx; i++){
            for(int j=ship.getLocation().getY(); j<ship.getLocation().getY()+dy; j++){
                if(this.arena[i][j] == true){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean updateArenaAfterAddShip(Ship ship){
        int dx = ship.getAlignment().equals(Alignment.HORIZONTAL)? ship.getShipCategory().getLength() : 0;
        int dy = ship.getAlignment().equals(Alignment.VERTICAL)? 0 : ship.getShipCategory().getLength();
        for(int i=ship.getLocation().getX(); i<ship.getLocation().getX()+dx; i++){
            for(int j=ship.getLocation().getY(); j<ship.getLocation().getY()+dy; j++){
                this.arena[i][j] = true;
            }
        }
        return true;
    }
}
