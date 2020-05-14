package com.game.controller;

import com.game.enums.Parameter;
import com.game.model.UserModel;
import com.game.service.Impl.UserServiceImpl;
import com.game.service.UserService;
import com.game.utils.BattleshipUtils;

import java.util.Map;

public class UserController {

    private UserService userService = new UserServiceImpl();

    public void registerUser(Map<Parameter, String> requestParams){
        UserModel userModel = BattleshipUtils.getUserModelFromParameters(requestParams);
        userService.registerUser(userModel);
    }
}
