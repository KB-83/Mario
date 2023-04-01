package Logic.Models.Entity;

import Logic.Models.LogicGameState;


public class Mario extends Player{

    public Mario(LogicGameState logicGameState){
        super(logicGameState);

        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
        this.screenX= 0;
        this.screenY= 480;
    }
}
