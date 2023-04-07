package Logic.Models.Entity;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Entity;
import Logic.Models.LogicGameState;
import Logic.Models.Tiles.CollisionChecker;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.awt.*;
@JsonDeserialize(as=Mario.class)
public abstract class Player extends Entity {

    public PlayerListener playerListener;
    CollisionChecker collisionChecker;
    // collision rect setting
    JumpPower jumpPow;
    public String name;
    public int imageNumber;
    int imageCounter;
    int lastYB4Jump = 12 * 48;
    int price;
    public boolean isUpCollisionOn,isRightCollisionOn,isBottomCollisionOn,isLeftCollisionOn;
    public Player(){}
    Player(LogicGameState logicGameState) {
        super();
        this.logicGameState = logicGameState;
        this.playerListener = new PlayerListener();
        this.logicGameState.lM.gM.panelsManagerCard.gamePanel.addKeyListener(playerListener);
        this.collisionChecker = new CollisionChecker(this);
    }

     public void update(){

        collisionChecker.checkCollision();

        String action = playerListener.keyAndMode;
         if (worldX >= this.logicGameState.background.topLeftColInWorld * size ) {
         switch (action) {
                 case "WP":
                     imageNumber = 4;
                     if (!isUpCollisionOn) {
//                         if(lastYB4Jump - screenY < 4 *48) {
                             this.screenY -= this.v;
                             this.worldY -= this.v;
//                         }
//                         else {
//                             playerJumpIsOver();
//                         }
                     }// it is jumped
                     break;
                 case "DP":
                     if (imageCounter < 12) {
                         imageNumber = 0;
                     } else {
                         imageNumber = 1;
                     }
                     imageCounter++;
                     if (!isRightCollisionOn) {
                         this.worldX += this.v;
                         if (screenX <= 26 * 48 / 2) {
                             this.screenX += this.v;
                         }
                         else {
                             this.logicGameState.background.topLeftColInWorld = (this.worldX - (26 * 48 /2) ) / size;
                         }
                     }
                     lastYB4Jump = this.screenY;
                     break;
                 case "AP":
                     if (imageCounter < 12) {
                         imageNumber = 2;
                     } else {
                         imageNumber = 3;
                     }
                     imageCounter++;
                     if(!isLeftCollisionOn){
                     if(this.screenX > 0){
                         this.screenX -= v;
                         this.worldX -= v;
                     }
                     }
//                     else {
//                     this.worldX -= this.v;
//                     }

                     lastYB4Jump = this.screenY;
                     break;

                 case "SP":
                     imageNumber = 6;
                     imageCounter++;
                     if (!isBottomCollisionOn) {
                         if (screenY< size * (this.logicGameState.rows) - size) {
                             this.screenY += this.v;
                             this.worldY += this.v;
                         }
                     }

                     lastYB4Jump = this.screenY;
                     break;
             case "WR":
//                 playerJumpIsOver();
                 break;
             }
         }
         else {
             worldX = this.logicGameState.background.topLeftColInWorld * size;
         }
         if (imageCounter > 24) {
             imageCounter = 0;
         }
         this.logicGameState.lM.gM.guiGameState.guiPlayer.setImage(imageNumber);
//         System.out.println(this.logicGameState.background.topLeftColInWorld);
     }

     private void playerJumpIsOver(){
         try {
             Thread.sleep(300);
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         while (screenY < lastYB4Jump) {
            screenY += 2*v;
            try {
                Thread.sleep(1000/60);//fps
                logicGameState.lM.gM.guiGameState.gamePanel.repaint();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
     }

    @Override
    void setCollision() {
        collision = new Rectangle(0,0,48,48);
    }

    public PlayerListener getPlayerListener() {
        return playerListener;
    }

    public void setPlayerListener(PlayerListener playerListener) {
        this.playerListener = playerListener;
    }

    public CollisionChecker getCollisionChecker() {
        return collisionChecker;
    }

    public void setCollisionChecker(CollisionChecker collisionChecker) {
        this.collisionChecker = collisionChecker;
    }

    public JumpPower getJumpPow() {
        return jumpPow;
    }

    public void setJumpPow(JumpPower jumpPow) {
        this.jumpPow = jumpPow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(int imageNumber) {
        this.imageNumber = imageNumber;
    }

    public int getImageCounter() {
        return imageCounter;
    }

    public void setImageCounter(int imageCounter) {
        this.imageCounter = imageCounter;
    }

    public int getLastYB4Jump() {
        return lastYB4Jump;
    }

    public void setLastYB4Jump(int lastYB4Jump) {
        this.lastYB4Jump = lastYB4Jump;
    }

    public boolean isUpCollisionOn() {
        return isUpCollisionOn;
    }

    public void setUpCollisionOn(boolean upCollisionOn) {
        isUpCollisionOn = upCollisionOn;
    }

    public boolean isRightCollisionOn() {
        return isRightCollisionOn;
    }

    public void setRightCollisionOn(boolean rightCollisionOn) {
        isRightCollisionOn = rightCollisionOn;
    }

    public boolean isBottomCollisionOn() {
        return isBottomCollisionOn;
    }

    public void setBottomCollisionOn(boolean bottomCollisionOn) {
        isBottomCollisionOn = bottomCollisionOn;
    }

    public boolean isLeftCollisionOn() {
        return isLeftCollisionOn;
    }

    public void setLeftCollisionOn(boolean leftCollisionOn) {
        isLeftCollisionOn = leftCollisionOn;
    }
}