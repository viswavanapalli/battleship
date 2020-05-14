package com.game.model;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.ShipCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateShipModel {
    private int playerId;
    private int gameId;
    private Alignment alignment;
    private ShipCategory shipCategory;
    private Location location;
}



//    GAME=1 ALIGNMENT=HORIZONTAL SHIP=CARRIER LOCATION=A1 player