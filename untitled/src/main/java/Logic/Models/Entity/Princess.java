package Logic.Models.Entity;

import Logic.Models.LogicGameState;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("princess")
public class Princess extends Player{
    public Princess() {
    }

    public Princess(User currentUser){
        super(currentUser);
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
