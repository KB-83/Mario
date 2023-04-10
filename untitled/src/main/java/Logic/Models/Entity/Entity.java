package Logic.Models.Entity;

import Logic.Models.LogicGameState;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;

public abstract class Entity {

    @JsonIgnore
    public LogicGameState logicGameState;

    Rectangle collision;

    public int v;
    public int screenX,screenY;
    public int worldX,worldY;

    public int size = 48;//pixel//maybe unusable (just tiles needed)
    public Entity(){
    }


    abstract void setCollision();
    public void setLogicGameState(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
    }

    public LogicGameState getLogicGameState() {
        return logicGameState;
    }

    public Rectangle getCollision() {
        return collision;
    }

    public void setCollision(Rectangle collision) {
        this.collision = collision;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getScreenX() {
        return screenX;
    }

    public void setScreenX(int screenX) {
        this.screenX = screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public void setScreenY(int screenY) {
        this.screenY = screenY;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
