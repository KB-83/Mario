package Logic.Models.Entity;

import Logic.Models.Entity.Entity;

public abstract class Player extends Entity {

    JumpPower jumpPow;
    void action(String action) {
        switch (action){
            case "WP":
                this.y -= this.v; // it is jump
                break;
            case "DP":
                this.x += this.v;
                break;
            case "AP":
                this.x =- this.v;
                break;
        }
    }
}
