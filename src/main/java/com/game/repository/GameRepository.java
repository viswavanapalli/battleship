package com.game.repository;

import com.game.entity.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRepository {
    private static int id=1;

    private volatile static GameRepository gameRepository;

    /**
     *
     * gameDetails mimic User Table entries in Database
     *
     */
    private List<Game> gameDetails = new ArrayList<>();

    private GameRepository(){};

    public static GameRepository getInstance()
    {
        if (gameRepository == null)
        {
            // To make thread safe
            synchronized (GameRepository.class)
            {
                // check again as multiple threads
                // can reach above step
                if (gameRepository ==null)
                    gameRepository = new GameRepository();
            }
        }
        return gameRepository;
    }

    public Game saveGame(Game game){
        game.setId(id);
        gameDetails.add(game);
        id++;
        return game;
    }

    public Game findById(int gameId){
        List<Game> games = gameDetails.stream()
                .filter(game -> gameId == game.getId())
                .collect(Collectors.toList());
        if(games.size()>0)
            return games.get(0);
        else
            return null;
    }

    public Game updateGame(Game game) {
        Game gameRecord = findById(game.getId());
        gameRecord = game;
        return gameRecord;
    }
}
