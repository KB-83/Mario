package Logic.Models.Entity;

import Logic.LogicManager;
import Logic.Models.LogicGameState;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Mario extends Player{

    private static Mario mario;
    public Mario(LogicGameState logicGameState){
        super(logicGameState);

        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
        this.x = 0;
        this.y = 480+48;
    }


//    public static Mario getMario() {
//        if(mario == null) {
//            mario = new Mario();
//        }
//        return mario;
//    }
}
