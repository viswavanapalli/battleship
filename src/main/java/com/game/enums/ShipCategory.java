package com.game.enums;

public enum ShipCategory {
    CARRIER(5),
    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);

    private int length;
    private ShipCategory(int length) {
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }
}