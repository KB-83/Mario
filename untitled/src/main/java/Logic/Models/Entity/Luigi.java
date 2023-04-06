package Logic.Models.Entity;

import Logic.Models.LogicGameState;

public class Luigi extends Player{
    public Luigi(LogicGameState logicGameState){
        super(logicGameState);
        this.name = "Luigi";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Luigi.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
    }
}
