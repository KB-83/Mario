package Graphic.Listeners;

import Graphic.GraphicManager;
import Logic.Models.Entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerListener implements KeyListener {

    private final GraphicManager gM;
    private final Player player;
    public String keyAndMode = ""; //exp : "WP" -> w pressed / "WR" -> w released /"" nothing

    public PlayerListener(GraphicManager gM, Player player){
        this.gM = gM;
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            keyAndMode = "WP";
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            keyAndMode = "DP";
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            keyAndMode = "AP";
        }

        gM.sendPlayerListenerAction(keyAndMode,player);

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

        gM.sendPlayerListenerAction(keyAndMode,player);

    }
}
