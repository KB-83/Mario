package Graphic.Models.Entity;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Panels.GamePanel;

import java.awt.*;

public abstract class GuiPlayer extends GuiEntity {
            GraphicManager gM;
            public PlayerListener listener;
            GamePanel gamePanel;
            Image image;
//    GraphicManager gM;
//
    GuiPlayer(GraphicManager gM, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gM = gM;
        this.listener = new PlayerListener(this.gM,this);
        this.gamePanel.addKeyListener(listener);
    }
    public abstract void setImage(String action);
}
