package com.game.repository;


import com.game.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerRepository {

    private static int id=1;

    private volatile static PlayerRepository playerRepository;

    /**
     *
     * playerDetails mimic User Table entries in Database
     *
     */
    private List<Player> playerDetails = new ArrayList<Player>();

    private PlayerRepository(){};

    public static PlayerRepository getInstance()
    {
        if (playerRepository == null)
        {
            // To make thread safe
            synchronized (PlayerRepository.class)
            {
                // check again as multiple threads
                // can reach above step
                if (playerRepository ==null)
                    playerRepository = new PlayerRepository();
            }
        }
        return playerRepository;
    }

    public Player savePlayer(Player player){
        player.setId(id);
        playerDetails.add(player);
        id++;
        return player;
    }

    public Player findById(int playerId){
        List<Player> players = playerDetails.stream()
                .filter(player -> playerId == player.getId())
                .collect(Collectors.toList());
        if(players.size()>0)
            return players.get(0);
        else
            return null;
    }

    public Player updatePlayer(Player player) {
        Player playerRecord = findById(player.getId());
        playerRecord = player;
        return playerRecord;
    }

}