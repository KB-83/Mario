package Logic.Models.Entity;

import Logic.Models.LogicGameState;


public class Mario extends Player{

    public Mario(LogicGameState logicGameState){
        super(logicGameState);

        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
        this.x = 0;
        this.y = 480+48;
    }
}
