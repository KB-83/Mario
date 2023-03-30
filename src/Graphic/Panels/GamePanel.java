package Graphic.Panels;

import Graphic.Listeners.PlayerListener;
import Graphic.Models.Entity.GuiMario;
import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.Tiles.GuiTileManager;
import Logic.Models.Entity.Enemy;
import Logic.Models.Entity.Player;
import Logic.Models.Tiles.Tile;
import Logic.Models.Tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    public PanelsManagerCard cardPanel;
    GuiPlayer player;
//    List<Tile> tileList;
    List<Enemy> enemies;
    GuiTileManager background;

    public GamePanel(PanelsManagerCard cardPanel){
        this.cardPanel = cardPanel;
        this.setFocusable(true);
//        this.addKeyListener(pL);
//        this.set
        this.setLayout(null);
        // needs to be optionable
        player = new GuiMario(cardPanel.graphicManager);
        loadBackGround();
    }

    public void loadBackGround(){
        this.background = new GuiTileManager(this);

    }
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        background.draw(g2);
        player.draw(g2);

    }
}
