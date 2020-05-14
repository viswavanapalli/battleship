package com.game.controller;

import com.game.enums.Parameter;
import com.game.model.CreateGameModel;
import com.game.service.GameService;
import com.game.service.Impl.GameServiceImpl;
import com.game.utils.BattleshipUtils;

import java.util.Map;

public class GameController {

    private GameService gameService = new GameServiceImpl();

    public void createGame(Map<Parameter, String> queryParams){
        CreateGameModel createGameModel = BattleshipUtils.getCreateGameModelFromParameters(queryParams);
        gameService.createGame(createGameModel);
    }

    public void startGame(Map<Parameter, String> queryParams){

    }

    public void endGame(Map<Parameter, String> queryParams){

    }

    public void pauseGame(Map<Parameter, String> queryParams){

    }
}
