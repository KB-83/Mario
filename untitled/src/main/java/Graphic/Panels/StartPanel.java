package Graphic.Panels;

import Util.GameLoop;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class StartPanel extends JPanel {

    JButton login;
    JButton signIn;
    JButton exit;
    JButton getSignIn;
    JButton getLogin;
    Image image;
    JTextArea loginName = new JTextArea("user name:");
    JTextArea loginPass = new JTextArea("pass:");
    JTextArea signName = new JTextArea("user name:");
    JTextArea signPass = new JTextArea("pass:");
    public PanelsManagerCard card;

    StartPanel(PanelsManagerCard card){

        this.card = card;
        this.setFocusable(true);
        this.setLayout(null);
        try {
            image = ImageIO.read(getClass().
                    getResourceAsStream("/Images/BackGround.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setTextAreas();
        seButtons();
        addActions();
        this.add(signName);
        this.add(signPass);
        this.add(loginName);
        this.add(loginPass);
        this.revalidate();



    }

    private void setTextAreas() {

        loginName.setForeground(Color.DARK_GRAY);
        loginPass.setForeground(Color.DARK_GRAY);
        signName.setForeground(Color.DARK_GRAY);
        signPass.setForeground(Color.DARK_GRAY);
        loginName.setBounds(3*48 + 50 + 30,520,100,40);
        loginPass.setBounds(3*48 + 50 + 30 + 100 + 30,520,100,40);
        signName.setBounds(3*48 + 50 + 30,460,100,40);
        signPass.setBounds(3*48 + 50 + 30 +100 + 30,460,100,40);
        loginName.setVisible(false);
        loginPass.setVisible(false);
        signName.setVisible(false);
        signPass.setVisible(false);
    }

    private void seButtons() {

        signIn = new JButton("sign in");
        login = new JButton("login");
        exit = new JButton("exit");
        getLogin = new JButton("ok");
        getSignIn = new JButton("ok");

        signIn.setBounds(3 * 48 - 50 , 460,100,40);
        login.setBounds(3 * 48 - 50, 520,100,40);
        exit.setBounds(3 * 48 - 50,580,100,40);
        getSignIn.setBounds(3 * 48 + 280 + 30, 460,50,40);
        getLogin.setBounds(3 * 48 + 280 + 30, 520,50,40);

        signIn.setFocusable(false);
        login.setFocusable(false);
        exit.setFocusable(false);
        getSignIn.setFocusable(false);
        getLogin.setFocusable(false);

        getLogin.setVisible(false);
        getSignIn.setVisible(false);

        this.add(signIn);
        this.add(login);
        this.add(exit);
        this.add(getLogin);
        this.add(getSignIn);
        this.revalidate();
    }
    private void addActions(){

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.startPanel.loginName.setVisible(true);
                card.startPanel.loginPass.setVisible(true);
                card.startPanel.getLogin.setVisible(true);
                card.startPanel.signName.setVisible(false);
                card.startPanel.signPass.setVisible(false);
                card.startPanel.getSignIn.setVisible(false);

            }
        });

        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.startPanel.loginName.setVisible(false);
                card.startPanel.loginPass.setVisible(false);
                card.startPanel.getLogin.setVisible(false);
                card.startPanel.signName.setVisible(true);
                card.startPanel.signPass.setVisible(true);
                card.startPanel.getSignIn.setVisible(true);
            }
        });

        getSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(card.gM.lM.userManager.signInRequest(signName.getText() , signPass.getText())){
                    card.cardLayout.show(card, "mainMenu");
//                    if(card.gM.lM.logicGameState == null){

                    }
//                    else {
//
//                        card.gM.guiGameState.loop.start();
//                    }
                }

//                card.gamePanel.requestFocus();

        });

        getLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(card.gM.lM.userManager.loginRequest(loginName.getText(),loginPass.getText())) {
                    card.gM.lM.userManager.newGameRequest();
                    card.gamePanel.setKeyListener(card.gM.lM.userManager.currentUser.getSelectedPlayer().getPlayerListener());
                    GameLoop gameLoop = new GameLoop(card.gM.lM, card.gM);
                    gameLoop.start();
                    card.cardLayout.show(card,"gamePanel");
                    card.gamePanel.requestFocus();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(image,0,0,1248,720,null);

    }
}
