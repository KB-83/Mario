package Logic.Models.Entity;

import Logic.Models.LogicGameState;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("mario")
public class Mario extends Player{
    public Mario(){}


    public Mario(User currentUser){
        super(currentUser);
        this.name = "Mario";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
    }
}
