package Graphic.Models.Entity;

import Graphic.Models.GuiPart;

import java.awt.*;

public abstract class GuiEntity implements GuiPart {
    Image[] images;
    abstract void loadImages();
}
