package com.game.service;

import com.game.entity.game.Player;

public interface PlayerService {
    public Player savePlayer(Player player);

    public Player updatePlayer(Player player);
}
