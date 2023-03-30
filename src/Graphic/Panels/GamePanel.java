package Graphic.Panels;
import Graphic.GraphicManager;
import Graphic.Models.GuiGameState;
import Util.GameLoop;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    GraphicManager gM;
    GameLoop gameLoop;
    public PanelsManagerCard cardPanel;
//    List<Tile> tileList;
    GuiGameState guiGameState;

    public GamePanel(PanelsManagerCard cardPanel, GraphicManager gM){
        this.gM = gM;
        this.cardPanel = cardPanel;
        this.setFocusable(true);
//        this.set
        this.setLayout(null);
//        this.gameLoop = new GameLoop(this.gM.lM,this.gM);
//        gameLoop.start();
        // needs to be optionable
        this.guiGameState = new GuiGameState(this,this.gM);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        guiGameState.background.draw(g2);
        guiGameState.guiPlayer.draw(g2);

    }
}
