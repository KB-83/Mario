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
import Logic.Models.Tiles.TileManager;

import java.util.List;

public class LogicGameState {
    LogicManager lM;
    public Player player;
    List<Enemy> enemies;
    public TileManager background;
    public LogicGameState(LogicManager lM){

        this.lM = lM;
        this.player = Mario.getMario();
//        this.background = new GuiTileManager(this.gamePanel);
    }
}
