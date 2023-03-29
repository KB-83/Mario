package Logic.Models.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Mario extends Player{

    private static Mario mario;
    private Mario(){

        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
        this.images = new Image[10];
        loadImages();
    }

    public static Mario getMario() {
        if(mario == null) {
            mario = new Mario();
        }
        return mario;
    }

    @Override
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
