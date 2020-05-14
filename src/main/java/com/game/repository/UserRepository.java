package com.game.repository;


import com.game.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    private static int id=1;

    private volatile static UserRepository userRepository;

    /**
     *
     * userDetails mimic User Table entries in Database
     *
     */
    private List<User> userDetails = new ArrayList<>();

    private UserRepository(){};

    public static UserRepository getInstance()
    {
        if (userRepository == null)
        {
            // To make thread safe
            synchronized (UserRepository.class)
            {
                // check again as multiple threads
                // can reach above step
                if (userRepository==null)
                    userRepository = new UserRepository();
            }
        }
        return userRepository;
    }

    public User saveUser(User user){
        user.setId(id);
        userDetails.add(user);
        id++;
        return user;
    }

    public User findById(int userId){
        List<User> users = userDetails.stream()
                .filter(user -> userId == user.getId())
                .collect(Collectors.toList());
        if(users.size()>0)
            return users.get(0);
        else
            return null;
    }

    public User findByName(String name){
        List<User> users = userDetails.stream()
                .filter(user -> name.equals(user.getName()))
                .collect(Collectors.toList());
        if(users.size()>0)
            return users.get(0);
        else
            return null;
    }

    public User updateUser(User user) {
        User userRecord = findById(user.getId());
        userRecord = user;
        return userRecord;
    }




}