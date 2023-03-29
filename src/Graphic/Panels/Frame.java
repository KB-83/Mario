package Graphic.Panels;

import javax.swing.*;

public class Frame extends JFrame {

    JPanel mainPanel;
    public Frame(JPanel mainPanel){
        this.setSize(mainPanel.getPreferredSize());
        this.setLayout(null);
        this.setFocusable(false);
        this.add(mainPanel);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void setMainPanel(JPanel mainPanel) {
        this.remove(mainPanel);
        this.mainPanel = mainPanel;
        this.add(mainPanel);
        this.setVisible(true);
    }
}
