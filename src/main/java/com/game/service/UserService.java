package com.game.service;

import com.game.entity.User;
import com.game.model.UserModel;

public interface UserService {

    public User registerUser(UserModel userModel);

    public User fetchUserById(int userId);
}
