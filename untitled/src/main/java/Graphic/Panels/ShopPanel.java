package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class ShopPanel extends JPanel {
    User user;
    PanelsManagerCard card;
    ShopPanel(PanelsManagerCard card) {
        this.card = card;
        setBackground(Color.red);
    }
}
