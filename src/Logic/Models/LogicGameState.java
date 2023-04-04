package Logic.Models;

import Graphic.GraphicManager;
import Graphic.Models.Entity.GuiMario;
import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.Tiles.GuiTileManager;
import Graphic.Panels.GamePanel;
import Logic.LogicManager;
import Logic.Models.Entity.Enemy;
import Logic.Models.Entity.Mario;
import Logic.Models.Entity.Player;
import Logic.Models.Tiles.CollisionChecker;
import Logic.Models.Tiles.TileManager;

import java.util.List;


public class LogicGameState {
    public LogicManager lM;
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
        this.selectedUser = new User(this);
        this.player = new Mario(this);
        selectedUser.player = player;

    }

    public void update(){
        selectedUser.update();
    }
}
