package Graphic;

import Graphic.Listeners.PlayerListener;
import Graphic.Models.Tiles.GuiTileManager;
import Graphic.Panels.Frame;
import Graphic.Panels.GamePanel;
import Graphic.Panels.PanelsManagerCard;
import Logic.LogicManager;
import Logic.Models.Entity.Player;

import java.awt.*;

public class GraphicManager {

    private  LogicManager lM ;
    Frame frame;


    public GraphicManager(LogicManager lM) {

        this.lM = lM;
        this.frame = new Frame(this);
    }

    public void sendPlayerListenerAction(String action, Player player) {
        lM.playerAction(action,player);
    }

    public void paintAll() {
        frame.paintAll();
    }

}
