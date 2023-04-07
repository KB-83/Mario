package Logic.Models.Entity;

import Logic.Models.LogicGameState;

public class Princess extends Player{
    public Princess(LogicGameState logicGameState){
        super(logicGameState);
        this.name = "Princess";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Princess.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
        this.price = 2000;
    }
}
