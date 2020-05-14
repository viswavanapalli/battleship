package com.game.service.Impl;

import com.game.entity.User;
import com.game.model.UserModel;
import com.game.repository.UserRepository;
import com.game.service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = UserRepository.getInstance();

    @Override
    public User registerUser(UserModel userModel) {
        User user = User.builder()
                .name(userModel.getName())
                .build();
        return userRepository.saveUser(user);
    }

    @Override
    public User fetchUserById(int userId) {
        return userRepository.findById(userId);
    }
}
