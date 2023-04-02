package Graphic.Panels;

import Graphic.Listeners.PlayerListener;
import Util.GameLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    JButton goToGame;
    public PanelsManagerCard card;

    LoginPanel(PanelsManagerCard card){
        this.card = card;
        this.setFocusable(true);
        setBackground(Color.red);
        this.setLayout(null);
        goToGame = new JButton("ll");
        goToGame.setBounds(13 * 48 - 50,300,100,30);
        goToGame.setForeground(Color.BLUE);
        goToGame.setFocusable(false);
        goToGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.gM.lM.startAGame();
                GameLoop gameLoop = new GameLoop(card.gM.lM,card.gM);
                gameLoop.start();
                card.cardLayout.show(card,"gamePanel");
                card.gamePanel.requestFocus();
            }
        });
        this.add(goToGame);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
