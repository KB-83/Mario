package Logic.Models.Entity;

import Logic.Models.LogicGameState;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("poker")
public class Poker extends Player{
    public static int price = 1000;
    public Poker() {
    }

    public Poker(User currentUser){
        super(currentUser);
        this.name = "Poker";
        this.jumpPow = JumpPower.Mario;
        this.v = V.Poker.v;
        this.screenX= 0;
        this.screenY= 480 + 48;
        this.worldX = 0;
        this.worldY = 480 + 48;
    }
}
