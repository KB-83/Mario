package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    User user;
    PanelsManagerCard card;
    ProfilePanel(PanelsManagerCard card) {
        this.card = card;
        this.setBackground(Color.red);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.red);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setFont(new Font("monospaced", Font.BOLD, 30));
        FontMetrics fm = g2.getFontMetrics();
        int textX = (this.getSize().width / 2) - (fm.stringWidth(user.getUserName()) / 2);
        g2.drawString(user.getUserName(), textX,140);
        textX = (this.getSize().width / 2) - (fm.stringWidth(String.valueOf(user.getHighScore())) / 2);
        g2.drawString(String.valueOf(user.getHighScore()), textX,200);

        textX = (this.getSize().width / 2) - (fm.stringWidth("selected player: "+user.getSelectedPlayer().name) / 2);
        g2.drawString("selected player: "+user.getSelectedPlayer().name, textX,260);

    }

    public void setUser(User user) {
        this.user = user;
    }
}
