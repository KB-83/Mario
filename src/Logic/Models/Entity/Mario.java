package Logic.Models.Entity;

public class Mario extends Player{

    private static Mario mario;
    private Mario(){

        this.jumpPow = JumpPower.Mario;
        this.v = V.Mario.v;
    }

    public static Mario getMario() {
        if(mario == null) {
            mario = new Mario();
        }
        return mario;
    }

    @Override
    void loadImages() {

    }
}
