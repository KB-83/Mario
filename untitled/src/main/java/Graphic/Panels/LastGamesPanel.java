package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LastGamesPanel extends JPanel {
    User user;
    PanelsManagerCard card;

    ButtonGroup bg = new ButtonGroup();
    JButton back = new JButton("<-");
    JButton ok =new  JButton("ok");

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
        ok.setBounds(this.getWidth()/2 - 25,550,50,50);
        this.add(ok);
        int x = 200;
        for (int i = 0;i < user.gameStatesList.size() ; i++){
            JRadioButton gameButton = new JRadioButton();
            lastGamesList[i] = gameButton;
            gameButton.setText(user.gameStatesList.get(i).massage);
            gameButton.setBounds(x,500,100,30);
            bg.add(gameButton);
            this.add(gameButton);
            x += 100;
        }
    }
    private void saveInfo(){
        File file = new File(user.getUserName() + ".json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            user.userManager.objectMapper.writeValue(fileWriter,user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
