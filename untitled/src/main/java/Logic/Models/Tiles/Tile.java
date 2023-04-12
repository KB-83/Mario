package Logic.Models.Tiles;

import java.awt.*;

public class Tile {
//    final int size = 48;
    boolean collision ;
    int num;
    public Tile(){}
    public Tile(boolean collision,int num){
        this.collision = collision;
        this.num = num;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
