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
    GraphicManager gM;
    public GamePanel gamePanel;
    public GuiPlayer guiPlayer;
    List<Enemy> enemies;
    public GuiTileManager background;
    public GuiGameState(GamePanel gamePanel, GraphicManager gM){
        this.gamePanel = gamePanel;
        this.gM = gM;
        this.guiPlayer = new GuiMario(this.gM, this.gamePanel);
        this.background = new GuiTileManager(this.gamePanel);
    }
    public void paintAll(Graphics2D g2){
//        System.out.print("start tile:");
//        System.out.println(System.currentTimeMillis());
        background.draw(g2);
//        System.out.print("end tile start mario:");
//        System.out.println(System.currentTimeMillis());
        guiPlayer.draw(g2);
//        System.out.print("end mario:");
//        System.out.println(System.currentTimeMillis());
    }
}
