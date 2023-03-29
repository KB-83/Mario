import Logic.Models.Entity.Mario;
import Logic.Models.GameState;
import sun.awt.image.BufferedImageDevice;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameState gameState = new GameState();
        Mario mario = Mario.getMario();
        System.out.println(mario.v);

    }
}
