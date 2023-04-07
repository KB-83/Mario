package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class LastGamesPanel extends JPanel {
    User user;
    PanelsManagerCard card;
    LastGamesPanel(PanelsManagerCard card) {
        this.card = card;
        setBackground(Color.red);
    }
    public void setUser() {
        this.user = this.card.gM.lM.userManager.currentUser;
    }
}
