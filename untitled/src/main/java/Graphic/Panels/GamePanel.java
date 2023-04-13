package Graphic.Panels;
import Graphic.GraphicManager;
import Graphic.Models.GuiGameState;
import Logic.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GamePanel extends JPanel {
    public GraphicManager gM;
    User currentUser;
    public PanelsManagerCard cardPanel;
    // needs gui game state to paint that
//    public GuiGameState guiGameState;

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
                saveInfo();
                cardPanel.lastGamesPanel.setLastGamesButtons();
                cardPanel.gM.lM.userManager.currentUser.currentGameState.getLoop().stop();
                cardPanel.cardLayout.show(cardPanel,"mainMenu");
            }
        });
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        if (currentUser.currentGameState != null){
        currentUser.currentGameState.guiGameState.paintAll(g2);
        if(currentUser.currentGameState.isOver() == true){
            g2.setFont(new Font("monospaced", Font.BOLD, 70));
            FontMetrics fm = g2.getFontMetrics();
            int textX = (this.getSize().width / 2) - (fm.stringWidth("GAME OVER")/ 2);
            g2.drawString("GAME OVER",textX,235);
        }
        }
        g2.setFont(new Font("monospaced", Font.BOLD, 30));
        g2.drawString(String.valueOf("COINS:"+currentUser.currentGameState.getCoins()),120,35);
        g2.drawString(String.valueOf("HEARTS:"+currentUser.currentGameState.getHearts()),320,35);
        g2.drawString(String.valueOf("SCORE:"+currentUser.currentGameState.getScore()),520,35);
        g2.drawString(String.valueOf("TIME:"+currentUser.currentGameState.getRemainingTime()),720,35);

    }
    public void setKeyListener(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    private void saveInfo(){
        File file = new File(currentUser.getUserName() + ".json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            currentUser.userManager.objectMapper.writeValue(fileWriter,currentUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
