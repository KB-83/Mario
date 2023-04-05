package Graphic.Panels;
import Graphic.GraphicManager;
import Graphic.Models.GuiGameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    public GraphicManager gM;
    public PanelsManagerCard cardPanel;
    // needs gui game state to paint that
    public GuiGameState guiGameState;

    JButton pause = new JButton("ll");

    public GamePanel(PanelsManagerCard cardPanel, GraphicManager gM){
        this.gM = gM;
        this.cardPanel = cardPanel;
        this.setFocusable(true);
        this.setLayout(null);
        pause.setBounds(0,0,50,50);
        pause.setFocusable(false);
        this.add(pause);
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardPanel.gM.guiGameState.loop.stop();
                cardPanel.cardLayout.show(cardPanel,"startPanel");
            }
        });
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
