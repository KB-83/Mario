package Logic.Models.Entity;

import Graphic.Listeners.PlayerListener;
import Logic.Models.Entity.Entity;

public abstract class Player extends Entity {

    JumpPower jumpPow;
    Player(){

    }
     public void action(String action) {
         System.out.println("player action");
        switch (action){
            case "WP":
                this.y -= this.v; // it is jump
                break;
            case "DP":
                this.x += this.v;
                break;
            case "AP":
                this.x -= this.v;
                break;
        }
    }
}
