package Graphic.Models.Entity;

import Graphic.GraphicManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GuiMario extends GuiPlayer{
    public GuiMario(GraphicManager gM) {
        super(gM);
        loadImages();
    }

    @Override
    public void draw(Graphics2D g2) {

    }
    void loadImages() {
        try{

            images[0] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioRight1.png"));
            images[1] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioRight2.png"));
            images[2] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioLeft1.png"));
            images[3] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioLeft2.png"));
            images[4] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioJumpRight.png"));
            images[5] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioJumpLeft.png"));
            images[6] = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioLose.png"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
