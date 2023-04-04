package Graphic.Models.Entity;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Models.GuiGameState;
import Graphic.Panels.GamePanel;

import java.awt.*;

public abstract class GuiPlayer extends GuiEntity {
            GraphicManager gM;
            GuiGameState guiGameState;
            Image image;

    GuiPlayer(GraphicManager gM, GuiGameState guiGameState) {


        this.guiGameState = guiGameState;
        this.gM = gM;
    }
    public abstract void setImage(int imageNum);
}
