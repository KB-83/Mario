package Graphic.Panels;

import Logic.Models.User;
import Util.GameLoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewGamePanel extends JPanel {
    PanelsManagerCard card;
    User user;
    ButtonGroup bg = new ButtonGroup();
    JButton back = new JButton("<-");
    JButton ok =new  JButton("ok");
    JTextArea newGameMassage = new JTextArea("newGameMassage");

    JRadioButton[] lastGamesList = new JRadioButton[3];
    NewGamePanel(PanelsManagerCard card) {
        setLayout(null);
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
        newGameMassage.setBounds(this.getWidth()/2-350 ,550,250,50);
        this.add(newGameMassage);
        ok.setBounds(this.getWidth()/2 - 25,550,50,50);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i<lastGamesList.length;i++) {
                    if (lastGamesList[i] != null && lastGamesList[i].isSelected()){
                        user.userManager.newGameRequest(lastGamesList[i].getText(),newGameMassage.getText());
                        setLastGamesOptions();
                        card.gamePanel.setKeyListener(card.gM.lM.userManager.currentUser.getSelectedPlayer().getPlayerListener());
                        GameLoop gameLoop = new GameLoop(card.gM.lM, card.gM);
                        gameLoop.start();
                        saveInfo();
                        card.cardLayout.show(card,"gamePanel");
                        card.gamePanel.requestFocus();
                        break;
                    }
                }

            }
        });
        this.add(ok);
        setLastGamesOptions();
    }
    public void setLastGamesOptions(){
        int x = 200;
        for (int i = 0;i < user.gameStatesList.size() ; i++){
            System.out.println("here setting Buttons newGamepanel");
            if(lastGamesList[i] != null){
                this.remove(lastGamesList[i]);
            }
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
