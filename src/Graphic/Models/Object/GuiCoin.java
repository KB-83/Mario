package Graphic.Models.Object;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class GuiCoin {

    Image image;
    int worldX,worldY;

    GuiCoin() {

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
