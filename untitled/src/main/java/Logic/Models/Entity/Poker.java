package Logic.Models.Entity;

import Logic.Models.LogicGameState;

public class Poker extends Player{
    public Poker(LogicGameState logicGameState){
        super(logicGameState);
        this.name = "Poker";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Poker.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
        this.price = 1000;
    }
}
