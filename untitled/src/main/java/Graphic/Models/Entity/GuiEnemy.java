package Graphic.Models.Entity;

import Logic.Models.Entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;

import static javax.management.timer.Timer.ONE_SECOND;

public class GuiEnemy extends GuiEntity {
    int worldX,worldY;
    int firstRow;
    int secondRow;
    Timer timer;

    Image image;
    //true == up
    boolean direction;

    public GuiEnemy (int worldX, int worldY) {
        this.worldX = worldX;
        this.worldY= worldY;
        firstRow = worldY/48;
        secondRow = firstRow+1;
        loadImage();
        timer = timerMaker();

    }
    private void goingUp(){
        worldY-=1;
        if( worldY < firstRow * 48){
            direction = false;
        }
    }
    private void goingDown(){
        worldY+= 1;
        if( worldY > secondRow * 48){
            direction = true;
        }
    }
    private Timer timerMaker(){
        timer = new Timer(1000/40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if( direction){
                    goingUp();
                }
                else {
                    goingDown();
                }
            }
        });
        return timer;
    }

    private void loadImage() {

        try {
                this.image = ImageIO.read(getClass().getResourceAsStream("/Images/Enemy/plant.png"));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    void loadImages() {

    }

    @Override
    public void draw(Graphics2D g2) {

    }
}
