package Logic.Models;

import Graphic.Models.Entity.GuiPlayer;
import Logic.LogicManager;
import Logic.Models.Entity.Player;

import java.util.ArrayList;

public class User {
    LogicGameState logicGameState;
    Player player;
    int score;
    int coins;
    ArrayList<String> ownedPlayers;

    public User(LogicGameState logicGameState) {
        this.logicGameState = logicGameState;
    }

    public void update(){
        this.player.update();
    }
}
