package Graphic.Models;

import java.awt.*;

public interface GuiPart {

    int worldCols = 26 * 4 ;
    int worldRows = 15 ;

    public int tileSize = 48;
    int playerSize = 48;
    void draw (Graphics2D g2);
}
