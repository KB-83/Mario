package Graphic.Models.Entity;

import Graphic.Models.GuiPart;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;

public abstract class GuiEntity implements GuiPart {
    Image[] images;
    public GuiEntity(){}
    abstract void loadImages();

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
