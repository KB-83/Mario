package Logic.Models.Entity;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Entity;

import java.awt.*;

public abstract class Player extends Entity {

    JumpPower jumpPow;
    public int imageNumber;
    int imageCounter;
    Player(){

    }
     public void action(String action) {
         switch (action) {
             case "WP":
                 imageNumber = 4;
                 this.y -= this.v; // it is jump
                 break;
             case "DP":
                 if (imageCounter < 2) {
                     imageNumber = 0;
                 } else {
                     imageNumber = 1;
                 }
                 imageCounter++;
                 this.x += this.v;
                 break;
             case "AP":
                 if (imageCounter < 2) {
                     imageNumber = 2;
                 } else {
                     imageNumber = 3;
                 }
                 imageCounter++;
                 this.x -= this.v;
                 break;
         }
         if (imageCounter > 4) {
             imageCounter = 0;
         }
     }
}