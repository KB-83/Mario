package Graphic.Panels;

import javax.swing.*;
import java.awt.*;

public class PanelsManagerCard extends JPanel {

    // panels will be added later
    GamePanel gamePanel;
    //info
    public final int cols = 26;
    public final int rows = 15;
    public final int tileSize = 48;
    public PanelsManagerCard(){
        this.gamePanel = new GamePanel(this);
        this.setLayout(new CardLayout());
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(cols*tileSize , rows*tileSize));
        //adding panels order is important
        this.add(gamePanel);
        // dont forget packing
    }
}
