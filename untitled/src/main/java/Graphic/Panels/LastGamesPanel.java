package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LastGamesPanel extends JPanel {
    User user;
    PanelsManagerCard card;

    ButtonGroup bg = new ButtonGroup();
    JButton back = new JButton("<-");

    JRadioButton[] lastGamesList = new JRadioButton[3];
    LastGamesPanel(PanelsManagerCard card) {
        this.setLayout(null);
        this.card = card;
        setBackground(Color.red);
        setInitialButtons();
    }
    public void setUser() {
        this.user = this.card.gM.lM.userManager.currentUser;
    }
    private void setInitialButtons(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.cardLayout.show(card,"mainMenu");
            }
        });
        back.setBounds(0,0,50,50);
        this.add(back);
    }
    public void setLastGamesButtons(){
        int x = 200;
        for (int i = 0;i < user.gameStatesList.size() ; i++){
            JRadioButton gameButton = new JRadioButton();
            gameButton.setText(user.gameStatesList.get(i).massage);
            gameButton.setBounds(x,500,100,30);
            bg.add(gameButton);
            this.add(gameButton);
            x += 100;
        }
    }
}
