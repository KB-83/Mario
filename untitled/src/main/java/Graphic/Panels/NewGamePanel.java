package Graphic.Panels;

import Logic.Models.User;

import javax.swing.*;
import java.awt.*;

public class NewGamePanel extends JPanel {
    PanelsManagerCard card;
    NewGamePanel(PanelsManagerCard card) {
        this.card = card;
        setBackground(Color.red);
    }
}
