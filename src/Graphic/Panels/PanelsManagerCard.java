package Graphic.Panels;

import Graphic.GraphicManager;

import javax.swing.*;
import java.awt.*;

public class PanelsManagerCard extends JPanel {
    GraphicManager graphicManager;
    // panels will be added later
    GamePanel gamePanel;
    //info
    public final int cols = 26;
    public final int rows = 15;
    public final int tileSize = 48;
    public PanelsManagerCard(GraphicManager graphicManager){
        this.graphicManager = graphicManager;

        this.gamePanel = new GamePanel(this);

        this.setLayout(new CardLayout());
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(cols*tileSize , rows*tileSize));
        //adding panels order is important
        this.add(gamePanel);
        // dont forget packing
    }
    public void paintComponent(Graphics g)
    {
        gamePanel.repaint();
    }
}
