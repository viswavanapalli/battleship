package com.game.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameModel {

    private String userId1;

    private String userId2;

    private String playerId1;

    private String playerId2;

    private String gameId;
}
