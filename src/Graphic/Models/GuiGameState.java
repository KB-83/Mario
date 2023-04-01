package Graphic.Models;

import Graphic.GraphicManager;
import Graphic.Models.Entity.GuiMario;
import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.Tiles.GuiTileManager;
import Graphic.Panels.GamePanel;
import Logic.Models.Entity.Enemy;

import java.awt.*;
import java.util.List;

public class GuiGameState {
    public GraphicManager gM;
    public GamePanel gamePanel;
    public GuiPlayer guiPlayer;
    List<Enemy> enemies;
    public GuiTileManager background;

    public GuiGameState(GamePanel gamePanel, GraphicManager gM){
        this.gamePanel = gamePanel;
        this.gM = gM;
        this.guiPlayer = new GuiMario(this.gM, this.gamePanel);
        this.background = new GuiTileManager(this);
    }
    public void paintAll(Graphics2D g2){

        background.draw(g2);
        guiPlayer.draw(g2);
    }
}
