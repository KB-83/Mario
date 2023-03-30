package Graphic.Panels;

import Graphic.GraphicManager;

import javax.swing.*;
import java.awt.*;

public class PanelsManagerCard extends JPanel {
    Frame frame;
    // panels will be added later
    public GamePanel gamePanel;
    GraphicManager gM;
    //info
    public final int cols = 26;
    public final int rows = 15;
    public final int tileSize = 48;
    public PanelsManagerCard(Frame frame,GraphicManager gM){
        this.gM = gM;
        this.frame = frame;

        this.gamePanel = new GamePanel(this,this.gM);

        this.setLayout(new CardLayout());
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(cols*tileSize , rows*tileSize));
        //adding panels order is important
        this.add(gamePanel);
        // dont forget packing
    }
    public void paintComponent(Graphics g)
    {
        System.out.println("here from cardpanel");
        gamePanel.repaint();
    }
}
