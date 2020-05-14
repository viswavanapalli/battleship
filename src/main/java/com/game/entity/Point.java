package com.game.entity;

import com.game.entity.ship.Ship;
import com.game.enums.Shot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private Location location;
    private Ship ship;
    private Shot shot;
    private boolean active = false;
}
