package Graphic.Panels;
import Graphic.GraphicManager;
import Graphic.Models.GuiGameState;
import Util.GameLoop;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GraphicManager gM;
    public PanelsManagerCard cardPanel;
    public GuiGameState guiGameState;

    public GamePanel(PanelsManagerCard cardPanel, GraphicManager gM){
        this.gM = gM;
        this.cardPanel = cardPanel;
        this.setFocusable(true);
        this.setLayout(null);
    }
    public void setGuiGameState(GuiGameState guiGameState){
        this.guiGameState = guiGameState;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (guiGameState != null){
        guiGameState.paintAll(g2);
        }

    }
}
