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

public class MainMenu extends JPanel {

    PanelsManagerCard card;
    User user;
    JButton startNewGame = new JButton("start new game");
    JButton continueLastGames = new JButton("continue last games");
    JButton shop = new JButton("shop");
    JButton profile = new JButton("profile");
    JButton logout = new JButton("logout");

    MainMenu(PanelsManagerCard card) {

        this.card = card;
        this.setLayout(null);
        this.setFocusable(false);
        this.setBackground(Color.RED);
        setButtonsBounds();
        setButtonsListeners();

        this.add(startNewGame);
        this.add(continueLastGames);
        this.add(shop);
        this.add(profile);
        this.add(logout);
        this.revalidate();
    }

    private void setButtonsBounds() {


        startNewGame.setBounds(26 * 48/2 -75,300,150,40);
        continueLastGames.setBounds(26 * 48/2 - 75,300 +50,150,40);
        shop.setBounds(26 * 48/2 - 75,300 +100,150,40);
        profile.setBounds(26 * 48/2 - 75,300 + 150,150,40);
        logout.setBounds(26 * 48/2 - 75,300 +200,150,40);

        startNewGame.setFocusable(false);
        continueLastGames.setFocusable(false);
        shop.setFocusable(false);
        profile.setFocusable(false);
        logout.setFocusable(false);

    }
    private void setButtonsListeners(){
        startNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                card.gM.lM.userManager.newGameRequest();
                card.cardLayout.show(card,"newGamePanel");
                card.newGamePanel.requestFocus();
//                card.gM.lM.userManager.newGameRequest(" from main menu");
//                    card.gamePanel.setKeyListener(card.gM.lM.userManager.currentUser.getSelectedPlayer().getPlayerListener());
//                    GameLoop gameLoop = new GameLoop(card.gM.lM, card.gM);
//                    gameLoop.start();
//                    card.cardLayout.show(card,"gamePanel");
//                    card.gamePanel.requestFocus();
            }
        });
        continueLastGames.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.cardLayout.show(card,"lastGamesPanel");
            }
        });
        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.cardLayout.show(card,"profilePanel");
            }
        });
        shop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.cardLayout.show(card,"shopPanel");
                card.shopPanel.requestFocus();
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveInfo();
                card.gM.lM.userManager.currentUser = null;
                card.cardLayout.show(card,"startPanel");
                card.startPanel.requestFocus();
            }
        });
    }
    public void setUser() {
        this.user = this.card.gM.lM.userManager.currentUser;
        this.repaint();
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
