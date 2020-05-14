package com.game.utils;

import com.game.enums.Parameter;
import com.game.model.GameModel;
import com.game.model.UserModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BattleshipUtils {
    public static Map<Parameter, String> getParameterValues(String command) {
        Map<Parameter, String> parameterValues = new HashMap<Parameter, String>();
        String[] data = command.split(" ");
        int i = 0;
        while (i < data.length) {
            String[] parameterKeyValue = data[i].split("=");
            if(parameterKeyValue.length==2){
                parameterValues.put(Parameter.valueOf(parameterKeyValue[0].toUpperCase())
                        , parameterKeyValue[1]);
            }
            i++;
        }
        return parameterValues;
    }

    public static UserModel getUserModelFromParameters(Map<Parameter, String> requestParams){
        UserModel userModel = new UserModel();
        Iterator<Map.Entry<Parameter, String>> parameterValueItr = requestParams.entrySet().iterator();
        while(parameterValueItr.hasNext()) {
            Map.Entry<Parameter, String> entry = parameterValueItr.next();
            switch (entry.getKey()) {
                case NAME:
                    userModel.setName(entry.getValue());
                    break;
            }
        }
        return userModel;
    }

    public static GameModel getGameModelFromParameters(Map<Parameter, String> requestParams){
        GameModel gameModel = new GameModel();
        Iterator<Map.Entry<Parameter, String>> parameterValueItr = requestParams.entrySet().iterator();
        while(parameterValueItr.hasNext()) {
            Map.Entry<Parameter, String> entry = parameterValueItr.next();
            switch (entry.getKey()) {
                case USER1:
                    gameModel.setUserId1(entry.getValue());
                    break;
                case USER2:
                    gameModel.setUserId2(entry.getValue());
                    break;
                case PLAYER1:
                    gameModel.setPlayerId1(entry.getValue());
                    break;
                case PLAYER2:
                    gameModel.setPlayerId2(entry.getValue());
                    break;
                case GAME_ID:
                    gameModel.setGameId(entry.getValue());
                    break;
            }
        }
        return gameModel;
    }




}
