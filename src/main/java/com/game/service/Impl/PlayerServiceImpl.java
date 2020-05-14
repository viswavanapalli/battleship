package com.game.service.Impl;

import com.game.entity.game.Player;
import com.game.repository.PlayerRepository;
import com.game.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository = PlayerRepository.getInstance();

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.savePlayer(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.updatePlayer(player);
    }
}
