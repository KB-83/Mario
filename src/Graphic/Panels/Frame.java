package Graphic.Panels;

import Graphic.GraphicManager;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    GraphicManager gM;
    public PanelsManagerCard panelsManagerCard;
    public Frame(GraphicManager gM){

        this.gM = gM;
        this.panelsManagerCard = new PanelsManagerCard(this,this.gM);
        this.setFocusable(false);
        this.add(panelsManagerCard);
        this.pack();// check
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paintAll(){
        this.panelsManagerCard.repaint();
    }

}
