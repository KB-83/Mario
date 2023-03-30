package Graphic;

import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.GuiGameState;
import Graphic.Panels.Frame;
import Graphic.Panels.GamePanel;
import Logic.LogicManager;


public class GraphicManager {

    public LogicManager lM ;
    Frame frame;
    GamePanel gamePanel;
    GuiGameState guiGameState;


    public GraphicManager(LogicManager lM) {

        this.lM = lM;
        this.frame = new Frame(this);
        this.gamePanel = frame.panelsManagerCard.gamePanel;
        this.guiGameState = new GuiGameState(gamePanel,this);
//        System.out.println(gameLoop.toString());
    }

    public void sendPlayerListenerAction(String action, GuiPlayer guiPlayer) {
        this.frame.panelsManagerCard.gamePanel.guiGameState.guiPlayer.setImage(action);
        lM.playerAction(action,guiPlayer);
    }

    public void paintAll() {
        gamePanel.repaint();
    }

}
