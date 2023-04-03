package Graphic.Panels;

import Graphic.GraphicManager;

import javax.swing.*;
import java.awt.*;

public class PanelsManagerCard extends JPanel {
    Frame frame;
    // panels will be added later
    public GamePanel gamePanel;
    public StartPanel startPanel;
    GraphicManager gM;
    CardLayout cardLayout = new CardLayout();
    //info
    public final int cols = 26;
    public final int rows = 15;
    public final int tileSize = 48;
    public PanelsManagerCard(Frame frame,GraphicManager gM){
        this.gM = gM;
        this.frame = frame;
        // other panels going to be added here
        this.gamePanel = new GamePanel(this,this.gM);
        this.startPanel = new StartPanel(this);
        // panel settings

        this.setLayout(cardLayout);
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(cols*tileSize , rows*tileSize));
        //adding panels order is important
        this.add(startPanel , "starPanel");
        this.add(gamePanel, "gamePanel");
        this.revalidate();
        // dont forget packing
    }
    public void paintComponent(Graphics g) {
        gamePanel.repaint();
    }
}
