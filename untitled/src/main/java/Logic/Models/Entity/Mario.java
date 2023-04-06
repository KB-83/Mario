package Logic.Models.Entity;

import Logic.Models.LogicGameState;


public class Mario extends Player{

    public Mario(){
        super();
        this.name = "Mario";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
    }
}
