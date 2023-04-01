package Logic.Models.Entity;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Entity;
import Logic.Models.LogicGameState;

import java.awt.*;

public abstract class Player extends Entity {

    JumpPower jumpPow;
    public int imageNumber;
    int imageCounter;
    LogicGameState logicGameState;
    public PlayerListener playerListener;
    Player(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
        this.playerListener = new PlayerListener();
    }

     public void update(){

        String action = playerListener.keyAndMode;
         if (worldX >= 0 ) {
         switch (action) {
                 case "WP":
                     imageNumber = 4;
                     this.screenY -= this.v; // it is jumped
                     break;
                 case "DP":
                     if (imageCounter < 12) {
                         imageNumber = 0;
                     } else {
                         imageNumber = 1;
                     }
                     imageCounter++;
                     if(screenX > 26*48 /2){
                     this.worldX += this.v;}
                     else {
                         this.screenX += this.v;
                     }
                     break;
                 case "AP":
                     if (imageCounter < 12) {
                         imageNumber = 2;
                     } else {
                         imageNumber = 3;
                     }
                     imageCounter++;
                     if(screenX > 0){
                         screenX -= v;
                     }
//                     else {
//                     this.worldX -= this.v;
//                     }
                     break;
                 case "SP":
                     imageNumber = 6;
                     imageCounter++;
                     this.screenY += this.v;
                     break;
             }
         }
         else {
             worldX = 0;
         }
         if (imageCounter > 24) {
             imageCounter = 0;
         }
         this.logicGameState.lM.gM.guiGameState.guiPlayer.setImage(imageNumber);
     }
}