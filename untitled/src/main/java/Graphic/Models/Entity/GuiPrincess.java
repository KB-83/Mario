package Graphic.Models.Entity;

import Graphic.GraphicManager;
import Graphic.Models.GuiGameState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GuiPrincess extends GuiPlayer{
    public GuiPrincess(GraphicManager gM, GuiGameState guiGameState) {
        super(gM,guiGameState);
        images = new Image[10];
        loadImages();
        image = images[0];
    }

    @Override
    public void setImage(int imageNum) {

        this.image = images[imageNum];
    }


    void loadImages() {
        try{

            images[0] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessRight1.png"));
            images[1] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessRight2.png"));
            images[2] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessLeft1.png"));
            images[3] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessLeft2.png"));
            images[4] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessJumpRight.png"));
            images[5] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessJumpLeft.png"));
            images[6] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessLose.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(image, gM.lM.logicGameState.player.screenX , gM.lM.logicGameState.player.screenY,
                gM.guiGameState.background.tileSize, gM.guiGameState.background.tileSize, null);
    }
}
