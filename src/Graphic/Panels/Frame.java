package Graphic.Panels;

import Graphic.GraphicManager;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    GraphicManager gM;
    PanelsManagerCard panelsManagerCard;
    public Frame(GraphicManager gM){

        this.gM = gM;
        this.panelsManagerCard = new PanelsManagerCard(this,this.gM);
//        this.setSize(panelsManagerCard.getPreferredSize());
//        this.setLayout(null);
        this.setFocusable(false);
        this.add(panelsManagerCard);
        this.pack();// check
        this.setVisible(true);
//        this.paintAll();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void paintAll(){
        this.panelsManagerCard.repaint();
    }

//    public void setMainPanel(JPanel mainPanel) {
//        this.remove(mainPanel);
//        this.mainPanel = mainPanel;
//        this.add(mainPanel);
//        this.setVisible(true);
//    }
}
