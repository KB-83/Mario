package Logic.Models.Entity;

import java.awt.*;

public abstract class Entity {

    public int v;
    int x,y;
    int size;//pixel//maybe unusable (just tiles needed)
    Image[] images;
    abstract void loadImages();
}
