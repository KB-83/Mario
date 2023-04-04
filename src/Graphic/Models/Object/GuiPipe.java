package Graphic.Models.Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GuiPipe {

    int worldCol,worldRow;

    boolean isBiggerOne = false;

    Image image;

    public GuiPipe (boolean isBiggerOne , int worldCol, int worldRow ){
        this.worldCol = worldCol;
        this.worldRow = worldRow;
        this.isBiggerOne = isBiggerOne;
        loadImage();
    }

    private void loadImage() {

        try {
            if (isBiggerOne) {

                this.image = ImageIO.read(getClass().getResourceAsStream("/Images/Object/Pipe.png"));
            }
            else {

                this.image = ImageIO.read(getClass().getResourceAsStream("/Images/Object/p.png"));}
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
