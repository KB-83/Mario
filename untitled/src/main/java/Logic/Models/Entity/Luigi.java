package Logic.Models.Entity;

import Logic.Models.LogicGameState;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("luigi")
public class Luigi extends Player{
    public Luigi() {
    }

    public Luigi(User currentUser){
        super(currentUser);
        this.name = "Luigi";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Luigi.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
        this.price = 1000;
    }
}
