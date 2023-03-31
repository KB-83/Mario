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

    GuiPlayer(GraphicManager gM, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.gM = gM;
        /// change
        this.listener = gM.lM.logicGameState.player.playerListener;
        this.gamePanel.addKeyListener(listener);
    }
    public abstract void setImage(int imageNum);
}
