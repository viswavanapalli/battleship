package com.game.model;

import com.game.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TargetModel {
    private int playerId;
    private Location location;
    private int gameId;
}
