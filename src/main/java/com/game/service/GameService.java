package com.game.service;

import com.game.model.GameModel;

public interface GameService {
    public void createGame(GameModel gameModel);

    public void startGame(GameModel gameModel);

    public void endGame(GameModel gameModel);

    public void pauseGame(GameModel gameModel);
}
