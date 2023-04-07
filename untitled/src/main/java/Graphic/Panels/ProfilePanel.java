package Graphic.Panels;

import Logic.Models.Entity.Player;
import Logic.Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfilePanel extends JPanel {
    User user;
    PanelsManagerCard card;
    List<JRadioButton> playersOption = new ArrayList<>();
    JButton ok;
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
        setPlayersOption();

    }
    private void setPlayersOption(){
        int x = 100;
        ButtonGroup bg=new ButtonGroup();
        for (Player player:user.getOwnedPlayers()){
            JRadioButton jRadioButton=new JRadioButton(player.name);
            jRadioButton.setBounds(x,500,100,30);
            playersOption.add(jRadioButton);
            bg.add(jRadioButton);
            this.add(jRadioButton);
            x+=100;
        }
        ok = new JButton("ok");
        ok.setBounds(100,550,50,30);
        ok.addActionListener(new ActionListener() {
            String name="Mario";
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JRadioButton jRadioButton:playersOption){
                    if (jRadioButton.isSelected()){
                        name=jRadioButton.getText();
                        user.changeSelectedPlayer(name);
                        File file =new File(user.getUserName()+".json");
                        try {
                            FileWriter fileWriter = new FileWriter(file);
                            card.gM.lM.objectMapper.writeValue(fileWriter,user);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    }
                }

            }
        });
        this.add(ok);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
