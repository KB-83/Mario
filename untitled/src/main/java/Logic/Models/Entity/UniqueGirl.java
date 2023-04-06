package Logic.Models.Entity;

import Logic.Models.LogicGameState;

public class UniqueGirl extends Player{
    public UniqueGirl(LogicGameState logicGameState){
        super(logicGameState);
        this.name = "UniqueGirl";
        this.jumpPow = JumpPower.Mario;
        this.v = V.UniqueGirl.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
    }
}
