package Logic.Models;
import Graphic.Models.Entity.GuiLuigi;
import Logic.LogicManager;
import Logic.Models.Entity.*;
import Logic.Models.Tiles.TileManager;
import Util.GameLoop;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class LogicGameState {

    @JsonIgnore
    public LogicManager lM;

    private GameLoop loop;
    public Player currentPlayer;
    List<Enemy> enemies;
    public int cols =26;
    public int rows = 15;
    public int levelNum = 1;
    public int sectionNum = 1;
    public TileManager background;
    public String massage = "no";
//    public CollisionChecker collisionChecker;
    public LogicGameState(){}
    public LogicGameState(LogicManager lM){

        this.lM = lM;
        // asan ye vazi

        this.background = new TileManager(this);
        System.out.println(lM.userManager +" from logic game state");
        this.currentPlayer = lM.userManager.currentUser.selectedPlayer;
        currentPlayer.logicGameState = this;
//        selectedUser.player = player;

    }

    public void update(){
        currentPlayer.update();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setLoop(GameLoop loop) {
        this.loop = loop;
    }

}
