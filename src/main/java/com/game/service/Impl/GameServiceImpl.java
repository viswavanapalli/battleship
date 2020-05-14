package com.game.service.Impl;

import com.game.entity.User;
import com.game.entity.game.Game;
import com.game.entity.game.Player;
import com.game.enums.GameStatus;
import com.game.model.GameModel;
import com.game.repository.GameRepository;
import com.game.service.GameService;
import com.game.service.PlayerService;
import com.game.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    UserService userService = new UserServiceImpl();

    PlayerService playerService = new PlayerServiceImpl();

    GameRepository gameRepository = GameRepository.getInstance();

    @Override
    public void createGame(GameModel gameModel) {
        User user1 = userService.fetchUserById(Integer.parseInt(gameModel.getUserId1()));
        User user2 = userService.fetchUserById(Integer.parseInt(gameModel.getUserId2()));

        Player player1 = Player.builder()
                .userId(user1.getId())
                .build();
        Player player2 = Player.builder()
                .userId(user2.getId())
                .build();
        player1 = playerService.savePlayer(player1);
        player2 = playerService.savePlayer(player2);

        List<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        Game game = Game.builder()
                .players(players)
                .gameStatus(GameStatus.READY)
                .build();
        game = gameRepository.saveGame(game);

        player1.setGameId(game.getId());
        player2.setGameId(game.getId());

        playerService.updatePlayer(player1);
        playerService.updatePlayer(player2);
    }

    @Override
    public void startGame(GameModel gameModel) {

    }

    @Override
    public void endGame(GameModel gameModel) {

    }

    @Override
    public void pauseGame(GameModel gameModel) {

    }
}
