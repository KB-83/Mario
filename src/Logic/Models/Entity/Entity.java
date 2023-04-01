package Logic.Models.Entity;

import Logic.Models.LogicGameState;

import java.awt.*;

public abstract class Entity {


    LogicGameState logicGameState;

    public int v;
    public int screenX,screenY;
    public int worldX,worldY;

    int size;//pixel//maybe unusable (just tiles needed)
    Entity(LogicGameState logicGameState){
        this.logicGameState = logicGameState;
    }
}
