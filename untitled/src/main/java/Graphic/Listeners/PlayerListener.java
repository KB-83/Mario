package Graphic.Listeners;

import javax.sound.midi.Soundbank;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {

    public String keyAndMode = ""; //exp : "WP" -> w pressed / "WR" -> w released /"" nothing

    public PlayerListener(){

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("action event player listener");

        if(e.getKeyCode() == KeyEvent.VK_W) {
            keyAndMode = "WP";
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            keyAndMode = "DP";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keyAndMode = "AP";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keyAndMode = "SP";
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            keyAndMode = "WR";
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            keyAndMode = "DR";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keyAndMode = "AR";
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            keyAndMode = "SR";
        }


    }
}
