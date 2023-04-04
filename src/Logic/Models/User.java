package Logic.Models;

import Graphic.Models.Entity.GuiPlayer;
import Logic.LogicManager;
import Logic.Models.Entity.Player;

import java.util.ArrayList;
import java.util.List;

public class User {
    List<LogicGameState> gamesList;
    Player player;
    int score;
    int coins;
    int hearts;
    ArrayList<String> ownedPlayers;

    public User(List<LogicGameState> gamesList) {

        this.gamesList = gamesList;
    }

    public void update(){
        this.player.update();
    }
}
