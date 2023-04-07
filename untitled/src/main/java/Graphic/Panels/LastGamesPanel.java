package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class LastGamesPanel extends JPanel {
    PanelsManagerCard card;
    LastGamesPanel(PanelsManagerCard card) {
        this.card = card;
        setBackground(Color.red);
    }
}
