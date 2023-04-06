package Logic.Models;
import Graphic.Models.Entity.GuiLuigi;
import Logic.LogicManager;
import Logic.Models.Entity.*;
import Logic.Models.Tiles.TileManager;
import Util.GameLoop;

import java.util.List;


public class LogicGameState {


    public LogicManager lM;

    private GameLoop loop;
    private User selectedUser;
    public Player player;
    List<Enemy> enemies;
    public int cols =26;
    public int rows = 15;
    public TileManager background;
//    public CollisionChecker collisionChecker;
    public LogicGameState(LogicManager lM){

        this.lM = lM;

        this.background = new TileManager(this);
        this.player = new UniqueGirl(this);
        player.logicGameState = this;
//        selectedUser.player = player;

    }

    public void update(){
        player.update();
    }

    public void setLoop(GameLoop loop) {
        this.loop = loop;
    }
}
