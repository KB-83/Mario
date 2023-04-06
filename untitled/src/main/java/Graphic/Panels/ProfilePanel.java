package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    User user;
    PanelsManagerCard card;
    ProfilePanel(PanelsManagerCard card) {
        this.card = card;
        setBackground(Color.red);
    }
}
