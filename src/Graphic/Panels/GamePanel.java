package Graphic.Panels;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Enemy;
import Logic.Models.Entity.Player;
import Logic.Models.Tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    Player player;
//    List<Tile> tileList;
    List<Enemy> enemies;
    private final int cols = 26;
    private final int rows = 15;
    private final int tileSize = 48;

    GamePanel(PlayerListener pL){
        this.setPreferredSize(new Dimension(cols*tileSize , rows*tileSize));
        this.setFocusable(true);
        this.addKeyListener(pL);
    }

    public void loadBackGround(){}
}
