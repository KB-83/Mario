package Graphic;

import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.GuiGameState;
import Graphic.Panels.Frame;
import Graphic.Panels.GamePanel;
import Logic.LogicManager;

import java.awt.*;


public class GraphicManager {

    public LogicManager lM ;
    Frame frame;
    GamePanel gamePanel;
    Graphics2D g2;
    public GuiGameState guiGameState;


    public GraphicManager(LogicManager lM) {

        this.lM = lM;
        this.frame = new Frame(this);
        this.gamePanel = frame.panelsManagerCard.gamePanel;
        this.guiGameState = new GuiGameState(gamePanel,this);
        this.gamePanel.setGuiGameState(guiGameState);
//        System.out.println(gameLoop.toString());
    }


    public void paintAll() {

        frame.paintAll();
    }

}
