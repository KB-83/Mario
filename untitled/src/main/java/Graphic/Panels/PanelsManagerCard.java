package Graphic.Panels;

import Graphic.GraphicManager;
import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class PanelsManagerCard extends JPanel {
    Frame frame;
    GraphicManager gM;
    // panels will be added later
    public GamePanel gamePanel;
    public StartPanel startPanel;
    public MainMenu mainMenu;
    public ProfilePanel profilePanel;
    public ShopPanel shopPanel;
    public NewGamePanel newGamePanel;
    public LastGamesPanel lastGamesPanel;
    public CardLayout cardLayout = new CardLayout();
    //info
    public final int cols = 26;
    public final int rows = 15;
    public final int tileSize = 48;
    public PanelsManagerCard(Frame frame,GraphicManager gM){
        this.gM = gM;
        this.frame = frame;
        // other panels going to be added here
        this.gamePanel = new GamePanel(this,this.gM);
        this.startPanel = new StartPanel(this);
        this.mainMenu = new MainMenu(this);
        this.shopPanel = new ShopPanel(this);
        this.profilePanel = new ProfilePanel(this);
        this.newGamePanel = new NewGamePanel(this);
        this.lastGamesPanel = new LastGamesPanel(this);
        // panel settings

        this.setLayout(cardLayout);
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(cols*tileSize , rows*tileSize));
        //adding panels order is important
        this.add(startPanel , "startPanel");
        this.add(gamePanel, "gamePanel");
        this.add(mainMenu,"mainMenu");
        this.add(shopPanel,"shopPanel");
        this.add(profilePanel,"profilePanel");
        this.add(newGamePanel,"newGamePanel");
        this.add(lastGamesPanel,"lastGamesPanel");
        this.revalidate();
        // dont forget packing
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gamePanel.repaint();
        shopPanel.repaint();
        profilePanel.repaint();
        newGamePanel.repaint();
        lastGamesPanel.repaint();
    }
    public void setCurrentUser(User user){
        mainMenu.setUser();
        shopPanel.setUser();
        profilePanel.setUser();
        newGamePanel.setUser();
        lastGamesPanel.setUser();
        gamePanel.setCurrentUser(user);
    }
}
