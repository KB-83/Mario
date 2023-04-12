package Graphic.Models.Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GuiCoin {

    Image image;
    public int worldCol,worldRow;
    public boolean isEaten = false;

    GuiCoin(int worldCol,int worldRow) {

        this.worldCol = worldCol;
        this.worldRow = worldRow;
        isEaten = false;
        loadImage();

    }

    private void loadImage() {

        try {
            this.image = ImageIO.read(getClass().getResourceAsStream("/Images/Object/image.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
