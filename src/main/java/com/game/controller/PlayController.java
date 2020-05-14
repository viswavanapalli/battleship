package com.game.controller;

import com.game.enums.Parameter;
import com.game.model.CreateShipModel;
import com.game.model.TargetModel;
import com.game.service.Impl.PlayerServiceImpl;
import com.game.service.PlayerService;
import com.game.utils.BattleshipUtils;

import java.lang.annotation.Target;
import java.util.Map;

public class PlayController {

    private PlayerService playerService = new PlayerServiceImpl();

    public void createShip(Map<Parameter, String> requestParams){
        CreateShipModel createShipModel = BattleshipUtils.getCreateShipModelFromParameters(requestParams);
        playerService.addShip(createShipModel);
    }

    public void target(Map<Parameter, String> requestParams){
        TargetModel targetModel = BattleshipUtils.getTargetModelFromParameters(requestParams);
        playerService.target(targetModel);
    }
}
