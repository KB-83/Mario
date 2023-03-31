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
    int counter = 0;
    long time = System.nanoTime();
    public GuiGameState(GamePanel gamePanel, GraphicManager gM){
        this.gamePanel = gamePanel;
        this.gM = gM;
        this.guiPlayer = new GuiMario(this.gM, this.gamePanel);
        this.background = new GuiTileManager(this.gamePanel);
    }
    public void paintAll(Graphics2D g2){
        counter++;
//        System.out.print("start tile:");
//        System.out.println(System.currentTimeMillis());
        background.draw(g2);
//        g2.dispose();
//        System.out.print("end tile start mario:");
//        System.out.println(System.currentTimeMillis());
        guiPlayer.draw(g2);
//        g2.dispose();
//        System.out.print("end mario:");
//        System.out.println(System.currentTimeMillis());
        if(System.nanoTime()-time >= 1000000000){
//            System.out.println(counter +"repaint called");
            counter = 0;
            time = System.nanoTime();
        }
    }
}
