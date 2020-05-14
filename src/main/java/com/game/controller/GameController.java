package com.game.controller;

import com.game.enums.Parameter;
import com.game.model.GameModel;
import com.game.utils.BattleshipUtils;

import java.util.Map;

public class GameController {
    public void createGame(String playerMetadata, Map<Parameter, String> queryParams){
        GameModel gameModel = BattleshipUtils.getGameModelFromParameters(queryParams);

    }

    public void startGame(String playerMetadata, Map<Parameter, String> queryParams){

    }

    public void endGame(String playerMetadata, Map<Parameter, String> queryParams){

    }

    public void pauseGame(String playerMetadata, Map<Parameter, String> queryParams){

    }
}
