package com.game.entity;

import com.game.entity.Location;
import com.game.entity.Point;
import com.game.entity.ship.Ship;
import com.game.enums.Alignment;
import com.game.enums.Shot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Grid {

    private int id;

    protected int size;

    private Point[][] points;

    public Grid(int size) {
        this.size = size;
        this.points = new Point[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                points[i][j].setShot(Shot.BLANK);
            }
        }
    }



}
