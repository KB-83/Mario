package Graphic.Models.Entity;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Models.GuiGameState;
import Graphic.Models.GuiPart;
import Graphic.Panels.GamePanel;

import java.awt.*;

public abstract class GuiPlayer extends GuiEntity implements GuiPart {
            GraphicManager gM;
            GuiGameState guiGameState;
            Image image;

    public GuiPlayer(){}
    GuiPlayer(GraphicManager gM, GuiGameState guiGameState) {


        this.guiGameState = guiGameState;
        this.gM = gM;
    }
    public abstract void setImage(int imageNum);

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, gM.lM.userManager.currentUser.currentGameState.currentPlayer.screenX , gM.lM.userManager.currentUser.currentGameState.currentPlayer.screenY,
                playerSize,playerSize, null);
    }

}
