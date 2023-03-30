package Logic.Models.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Mario extends Player{

    private static Mario mario;
    private Mario(){

        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
    }

    public static Mario getMario() {
        if(mario == null) {
            mario = new Mario();
        }
        return mario;
    }
}
