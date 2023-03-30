package Graphic.Panels;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Enemy;
import Logic.Models.Entity.Player;
import Logic.Models.Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    public PanelsManagerCard cardPanel;
    Player player;
//    List<Tile> tileList;
    List<Enemy> enemies;
    List<Tile> background;

    public GamePanel(PanelsManagerCard cardPanel){
        this.cardPanel = cardPanel;
        this.setFocusable(true);
//        this.addKeyListener(pL);
//        this.set
        this.setLayout(null);
        loadBackGround();
    }

    public void loadBackGround(){
        this.background = new ArrayList<>();

    }
}
