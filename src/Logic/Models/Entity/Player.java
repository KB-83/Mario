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
         switch (action) {
             case "WP":
                 imageNumber = 4;
                 this.y -= this.v; // it is jumped
                 break;
             case "DP":
                 if (imageCounter < 12) {
                     imageNumber = 0;
                 } else {
                     imageNumber = 1;
                 }
                 imageCounter++;
                 this.x += this.v;
                 break;
             case "AP":
                 if (imageCounter < 12) {
                     imageNumber = 2;
                 } else {
                     imageNumber = 3;
                 }
                 imageCounter++;
                 this.x -= this.v;
                 break;
         }
         if (imageCounter > 24) {
             imageCounter = 0;
         }
         this.logicGameState.lM.gM.guiGameState.guiPlayer.setImage(imageNumber);
     }
}