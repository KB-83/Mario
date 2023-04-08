package Logic.Models.Entity;

import Logic.Models.LogicGameState;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("uniqueGirl")
public class UniqueGirl extends Player{
    public UniqueGirl(){}
    public UniqueGirl(User currentUser){
        super(currentUser);
        this.name = "UniqueGirl";
        this.jumpPow = JumpPower.Mario;
        this.v = V.UniqueGirl.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
        this.price = 5000;
    }
}
