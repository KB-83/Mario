package Logic.Models.Entity;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Entity;
import Logic.Models.LogicGameState;
import Logic.Models.Tiles.CollisionChecker;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.awt.*;
import java.awt.event.KeyListener;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Mario.class, name = "mario"),
        @JsonSubTypes.Type(value = Luigi.class, name = "luigi"),
        @JsonSubTypes.Type(value = Princess.class, name = "princess"),
        @JsonSubTypes.Type(value = UniqueGirl.class, name = "uniqueGirl"),
        @JsonSubTypes.Type(value = Poker.class, name = "poker")
})

public abstract class Player extends Entity {
    @JsonIgnore
    public User currentUser;

    public PlayerListener playerListener;
    @JsonIgnore
    public CollisionChecker collisionChecker;
    // collision rect setting
    JumpPower jumpPow;
    public String name;
    public int imageNumber;
    int imageCounter;
    int lastYB4Jump = 10 * 48;
    @JsonIgnore
    public Rectangle solidArea = new Rectangle(5,0,38,46);
    public boolean isCollisionOn;
    public boolean duringJump;
    Player(){
        super();
    }
    Player(User currentUser) {
        super();
        this.currentUser = currentUser;
        this.playerListener = new PlayerListener();
        this.currentUser.userManager.lM.gM.panelsManagerCard.gamePanel.addKeyListener(playerListener);
        this.collisionChecker = new CollisionChecker(this);
    }

     public void update() {
        isCollisionOn = false;
        collisionChecker.checkCollision();
         if(this.worldX >= 26 * 4 * 48 - 60){
             this.currentUser.userManager.sectionChanged();
             this.sectionChanged();
         }
        String action = playerListener.keyAndMode;
         if (worldX >= this.currentUser.currentGameState.background.topLeftColInWorld * size) {
             if (action.equals("WP")) {
                 if (imageNumber == 0 || imageNumber == 1 || imageNumber == 4) {
                     imageNumber = 4;
                 } else {
                     imageNumber = 5;
                 }
                 if (!isCollisionOn && duringJump == false) {
//                     playerWantsToJump();
                     worldY -= v;
                     screenY -= v;
                 }// it is jumped
             }
             if (action.equals("DP")) {
                 if (duringJump == false) {
                     if (imageCounter < 12) {
                         imageNumber = 0;
                     } else {
                         imageNumber = 1;
                     }
                     imageCounter++;
                 }
                 if (!isCollisionOn) {
                     this.worldX += this.v;
//                     while (!isBottomCollisionOn && worldY< 13 * 48) {
//                         collisionChecker.jumpOverCollisionChecker();
//                         screenY += v;
//                         worldY += v;
//                         try {
//                             Thread.sleep(1);//fps
//                             currentUser.userManager.lM.gM.panelsManagerCard.gamePanel.repaint();
//                         } catch (InterruptedException e) {
//                             throw new RuntimeException(e);
//                         }
                     if (screenX <= 26 * 48 / 2) {
                         this.screenX += this.v;
                     } else {
                         this.currentUser.currentGameState.background.topLeftColInWorld = (this.worldX - (26 * 48 / 2)) / size;
                     }
//                     }
//                     worldY -= v;
//                     screenY -= v;
                     duringJump = false;
                 }
                 if (duringJump == false) {
                     lastYB4Jump = this.screenY;
                 }
             }
             if (action.equals("AP")) {
                 if (duringJump == false) {
                     if (imageCounter < 12) {
                         imageNumber = 2;
                     } else {
                         imageNumber = 3;
                     }
                     imageCounter++;
                 }
                 if (!isCollisionOn) {
                     if (this.screenX > 0) {
                         this.screenX -= v;
                         this.worldX -= v;
                     }
                 }
//                 } else {
//                     this.worldX -= this.v;
//                 }
                 if (duringJump == false) {
                     lastYB4Jump = this.screenY;
                 }
             }

             if (action.equals("SP")) {
                 imageNumber = 6;
                 imageCounter++;
                 if (!isCollisionOn && duringJump == false) {
                     if (screenY < size * (this.currentUser.currentGameState.rows) - size) {
                         this.screenY += this.v;
                         this.worldY += this.v;
                     }
                 }

                 lastYB4Jump = this.screenY;
             }
//             if (action == "WR") {
//                 playerJumpIsOver();
//             }
         }
         else {
             worldX = this.currentUser.currentGameState.background.topLeftColInWorld * size;
         }
         if (imageCounter > 24) {
             imageCounter = 0;
         }
         this.currentUser.currentGameState.guiGameState.guiPlayer.setImage(imageNumber);
//         System.out.println(this.logicGameState.background.topLeftColInWorld);
     }
     private void playerWantsToJump(){
        duringJump =true;
         while (lastYB4Jump - screenY < 4 * 48) {
             this.screenY -= this.v;
             this.worldY -= this.v;
             if (playerListener.keyAndMode.equals("DP")){
                 this.worldX += 2*v;
                 if (screenX <= 26 * 48 / 2) {
                     this.screenX += 2*v;
                 } else {
                     this.currentUser.currentGameState.background.topLeftColInWorld = (this.worldX - (26 * 48 / 2)) / size;
                 }
             }
             else if (playerListener.keyAndMode.equals("AP")){
                 this.screenX -= v;
                 worldX -= v;
             }

             try {
                 Thread.sleep(1000/60);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             currentUser.userManager.lM.gM.panelsManagerCard.gamePanel.repaint();
         }
    }

//     private void playerJumpIsOver(){
//         try {
//             Thread.sleep(300);
//         } catch (InterruptedException e) {
//             throw new RuntimeException(e);
//         }
//         while (!isBottomCollisionOn && worldY<13 * 48) {
//             collisionChecker.jumpOverCollisionChecker();
//             screenY += v;
//             worldY += v;
//            try {
//                Thread.sleep(1000/60);//fps
//                currentUser.userManager.lM.gM.panelsManagerCard.gamePanel.repaint();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//         this.currentUser.currentGameState.update();
//         worldY -=v;
//         screenY -=v;
//         duringJump = false;
//     }
    private void sectionChanged(){
        this.screenX = 0;
        this.worldX = 0;
    }
    public void checkHearts(){
        if (this.worldY > 12 * 48 ){
            this.worldY = 480;
            this.worldX =0;
            this.screenY = worldY;
            this.screenX = worldX;
            this.currentUser.currentGameState.background.topLeftColInWorld = 0;
            currentUser.currentGameState.setHearts(currentUser.currentGameState.getHearts()-1);
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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isDuringJump() {
        return duringJump;
    }

    public void setDuringJump(boolean duringJump) {
        this.duringJump = duringJump;
    }
}