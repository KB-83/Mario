package Logic.Models.Entity;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Entity;

import java.awt.*;

public abstract class Player extends Entity {

    JumpPower jumpPow;
    public int imageNumber;
    int imageCounter;
    int action_called = 0;
    long actiontime = System.nanoTime();
    Player(){

    }
     public void action(String action) {
        action_called++;
         switch (action) {
             case "WP":
                 imageNumber = 4;
                 this.y -= this.v; // it is jump
                 break;
             case "DP":
                 if (imageCounter < 10) {
                     imageNumber = 0;
                 } else {
                     imageNumber = 1;
                 }
                 imageCounter++;
                 this.x += this.v;
                 break;
             case "AP":
                 if (imageCounter < 10) {
                     imageNumber = 2;
                 } else {
                     imageNumber = 3;
                 }
                 imageCounter++;
                 this.x -= this.v;
                 break;
         }
         if (imageCounter > 20) {
             imageCounter = 0;
         }
         if(System.nanoTime()-actiontime >= 1000000000){ // a test
//             System.out.println(action_called +" action time");
             actiontime = System.nanoTime();
             action_called = 0;
         }
     }
}