package Graphic.Models.Entity;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Models.GuiGameState;
import Graphic.Panels.GamePanel;

import java.awt.*;

public abstract class GuiPlayer extends GuiEntity {
            GraphicManager gM;
            GuiGameState guiGameState;
            public PlayerListener listener;
            Image image;

    GuiPlayer(GraphicManager gM, GuiGameState guiGameState) {


        this.guiGameState = guiGameState;
        this.gM = gM;
        /// change
//        this.listener = gM.lM.logicGameState.player.playerListener;
//        this.gamePanel.addKeyListener(listener);
    }
    public abstract void setImage(int imageNum);
}
