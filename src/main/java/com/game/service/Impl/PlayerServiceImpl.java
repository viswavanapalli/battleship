package com.game.service.Impl;

import com.game.entity.Game;
import com.game.entity.Grid;
import com.game.entity.Location;
import com.game.entity.Player;
import com.game.entity.ship.Ship;
import com.game.enums.Alignment;
import com.game.enums.GameStatus;
import com.game.factory.ShipFactory;
import com.game.model.CreateShipModel;
import com.game.model.TargetModel;
import com.game.repository.GameRepository;
import com.game.repository.PlayerRepository;
import com.game.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository = PlayerRepository.getInstance();

    private GameRepository gameRepository = GameRepository.getInstance();

    private ShipFactory shipFactory = new ShipFactory();

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.savePlayer(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.updatePlayer(player);
    }

    @Override
    public Player addShip(CreateShipModel createShipModel) {
        Ship ship = shipFactory.getShip(createShipModel.getShipCategory());
        ship.setAlignment(createShipModel.getAlignment());
        ship.setLocation(createShipModel.getLocation());
        Player player = playerRepository.findById(createShipModel.getPlayerId());
        Game game = gameRepository.findById(createShipModel.getGameId());

        if(validateShipLocation(ship, player.getGrid().getSize())){
            if(validateCollision(ship, player.getGrid())){
                updateGridAfterAddShip(ship, player.getGrid());
            }
        }
        player.getShips().add(ship);
        return player;
    }

    @Override
    public void target(TargetModel targetModel) {
        Player sourcePlayer = playerRepository.findById(targetModel.getPlayerId());
        Game game = gameRepository.findById(targetModel.getGameId());
        Location location = targetModel.getLocation();
        Player targetPlayer = null;
        if(game.getPlayer1().getId()== sourcePlayer.getId()){
            targetPlayer = game.getPlayer2();
        } else {
            targetPlayer = game.getPlayer1();
        }

        if(validateLocation(targetModel.getLocation(), targetPlayer.getGrid().getSize())){
            if(targetPlayer.getGrid().getPoints()[location.getX()][location.getY()].getShip() != null){
                targetPlayer.getGrid().getPoints()[location.getX()][location.getY()].setActive(false);
            }
        }

        if(checkEndGame(targetPlayer.getGrid())){
            game.setGameStatus(GameStatus.END);
            game.setWinner(sourcePlayer);
        }
    }


    public boolean validateLocation(Location location, int size){
        if(location.getX()>=0
                && location.getX()<size
                && location.getY()>=0
                && location.getY()<size){
            return true;
        } else{
            return false;
        }
    }


    public boolean validateShipLocation(Ship ship, int size){
        Location startLocation = ship.getLocation();
        Location endLocation = null;
        if(ship.getAlignment().equals(Alignment.HORIZONTAL)){
            endLocation = new Location(ship.getLocation().getX()+ ship.getShipCategory().getLength(), ship.getLocation().getY());
        } else if(ship.getAlignment().equals(Alignment.VERTICAL)){
            endLocation = new Location(ship.getLocation().getX(), ship.getLocation().getY() + ship.getShipCategory().getLength());
        }
        if(validateLocation(startLocation, size) && validateLocation(endLocation, size)){
            return true;
        }
        return false;
    }

    public boolean validateCollision(Ship ship, Grid grid){
        int dx = ship.getAlignment().equals(Alignment.HORIZONTAL)? ship.getShipCategory().getLength() : 0;
        int dy = ship.getAlignment().equals(Alignment.VERTICAL)? 0 : ship.getShipCategory().getLength();
        for(int i=ship.getLocation().getX(); i<ship.getLocation().getX()+dx; i++){
            for(int j=ship.getLocation().getY(); j<ship.getLocation().getY()+dy; j++){
                if(grid.getPoints()[i][j].getShip() != null){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean updateGridAfterAddShip(Ship ship, Grid grid){
        int dx = ship.getAlignment().equals(Alignment.HORIZONTAL)? ship.getShipCategory().getLength() : 0;
        int dy = ship.getAlignment().equals(Alignment.VERTICAL)? 0 : ship.getShipCategory().getLength();
        for(int i=ship.getLocation().getX(); i<ship.getLocation().getX()+dx; i++){
            for(int j=ship.getLocation().getY(); j<ship.getLocation().getY()+dy; j++){
                grid.getPoints()[i][j].setShip(ship);
                grid.getPoints()[i][j].setActive(true);
            }
        }
        return true;
    }

    public boolean checkEndGame(Grid grid){
        for(int i=0; i<grid.getPoints().length; i++){
            for(int j=0; j<grid.getPoints().length; j++){
                if(grid.getPoints()[i][j].isActive()){
                    return false;
                }
            }
        }
        return true;
    }
}