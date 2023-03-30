package Graphic;

import Graphic.Models.Entity.GuiPlayer;
import Graphic.Panels.Frame;
import Logic.LogicManager;


public class GraphicManager {

    public LogicManager lM ;
    Frame frame;


    public GraphicManager(LogicManager lM) {

        this.lM = lM;
        this.frame = new Frame(this);
//        System.out.println(gameLoop.toString());
    }

    public void sendPlayerListenerAction(String action, GuiPlayer guiPlayer) {

        lM.playerAction(action,guiPlayer);
    }

    public void paintAll() {
        frame.paintAll();
    }

}
