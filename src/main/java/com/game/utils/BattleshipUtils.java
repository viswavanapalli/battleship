package com.game.utils;

import com.game.entity.Location;
import com.game.enums.Alignment;
import com.game.enums.Parameter;
import com.game.enums.ShipCategory;
import com.game.model.CreateGameModel;
import com.game.model.CreateShipModel;
import com.game.model.TargetModel;
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

    public static CreateGameModel getCreateGameModelFromParameters(Map<Parameter, String> requestParams){
        CreateGameModel createGameModel = new CreateGameModel();
        Iterator<Map.Entry<Parameter, String>> parameterValueItr = requestParams.entrySet().iterator();
        while(parameterValueItr.hasNext()) {
            Map.Entry<Parameter, String> entry = parameterValueItr.next();
            switch (entry.getKey()) {
                case PLAYER1_USER:
                    createGameModel.setPlayer1UserId(entry.getValue());
                    break;
                case PLAYER2_USER:
                    createGameModel.setPlayer2UserId(entry.getValue());
                    break;
            }
        }
        return createGameModel;
    }

    public static CreateShipModel getCreateShipModelFromParameters(Map<Parameter, String> requestParams) {
        CreateShipModel createShipModel = new CreateShipModel();
        Iterator<Map.Entry<Parameter, String>> parameterValueItr = requestParams.entrySet().iterator();
        while (parameterValueItr.hasNext()) {
            Map.Entry<Parameter, String> entry = parameterValueItr.next();
            switch (entry.getKey()) {
                case PLAYER:
                    createShipModel.setPlayerId(Integer.parseInt(entry.getValue()));
                case GAME:
                    createShipModel.setGameId(Integer.parseInt(entry.getValue()));
                    break;
                case ALIGNMENT:
                    createShipModel.setAlignment(Alignment.valueOf(entry.getValue()));
                    break;
                case SHIP:
                    createShipModel.setShipCategory(ShipCategory.valueOf(entry.getValue()));
                    break;
                case LOCATION:
                    int x = (int)(entry.getValue().charAt(0) - 'A');
                    int y = Integer.parseInt(String.valueOf(entry.getValue().charAt(1)));
                    createShipModel.setLocation(new Location(x,y));
                    break;
            }
        }
        return createShipModel;
    }

    public static TargetModel getTargetModelFromParameters(Map<Parameter, String> requestParams){
        TargetModel targetModel = new TargetModel();
        Iterator<Map.Entry<Parameter, String>> parameterValueItr = requestParams.entrySet().iterator();
        while (parameterValueItr.hasNext()) {
            Map.Entry<Parameter, String> entry = parameterValueItr.next();
            switch (entry.getKey()) {
                case PLAYER:
                    targetModel.setPlayerId(Integer.parseInt(entry.getValue()));
                    break;
                case GAME:
                    targetModel.setGameId(Integer.parseInt(entry.getValue()));
                    break;
                case LOCATION:
                    int x = (int) (entry.getValue().charAt(0) - 'A');
                    int y = Integer.parseInt(String.valueOf(entry.getValue().charAt(1)));
                    targetModel.setLocation(new Location(x, y));
                    break;
            }
        }
        return targetModel;
    }

}

//        "PLAYER=1,COMMAND=CREATE_SHIP GAME=1 ALIGNMENT=HORIZONTAL SHIP=CARRIER LOCATION=A1",
