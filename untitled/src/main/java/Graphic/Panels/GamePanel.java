package Graphic.Panels;
import Graphic.GraphicManager;
import Graphic.Models.GuiGameState;
import Logic.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    public GraphicManager gM;
    User currentUser;
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

//                cardPanel.gM.guiUserManager.guiGameState.loop.stop();
                cardPanel.cardLayout.show(cardPanel,"startPanel");
            }
        });
    }
    public void setGuiGameState(GuiGameState guiGameState){
        this.guiGameState = guiGameState;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        if (guiGameState != null){
        guiGameState.paintAll(g2);
        }
        g2.setFont(new Font("monospaced", Font.BOLD, 30));
        g2.drawString(String.valueOf("COINS:"+currentUser.getCoins()),120,35);
        g2.drawString(String.valueOf("HEARTS:"+currentUser.getHearts()),320,35);
        g2.drawString(String.valueOf("SCORE:"+currentUser.getScore()),520,35);

    }
    public void setKeyListener(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
