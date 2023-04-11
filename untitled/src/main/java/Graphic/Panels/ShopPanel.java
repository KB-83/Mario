package Graphic.Panels;

import Logic.Models.Entity.*;
import Logic.Models.User;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShopPanel extends JPanel {
    PanelsManagerCard card;
    List<JRadioButton> buttonList = new ArrayList<>();
    User user;
    JButton buy =  new JButton("buy");

    private JRadioButton mario = new JRadioButton("Mario");
    private JRadioButton luigi = new JRadioButton("Luigi");
    private JRadioButton princess = new JRadioButton("Princess");
    private JRadioButton uniqueGirl = new JRadioButton("UniqueGirl");
    private JRadioButton poker = new JRadioButton("Poker");
    JButton back = new JButton("<-");
    Image playerImage;
    Image coinImage;
    int price;
    ShopPanel(PanelsManagerCard card) {
        this.setLayout(null);
        this.card = card;
        setBackground(Color.red);
        buttonList.add(mario);
        buttonList.add(luigi);
        buttonList.add(princess);
        buttonList.add(uniqueGirl);
        buttonList.add(poker);
        try {
            this.coinImage = ImageIO.read(getClass().getResourceAsStream("/Images/Object/image.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setButtons();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
            g2.setFont(new Font("monospaced", Font.BOLD, 30));
            g2.drawString(String.valueOf(user.getCoins()),530,55);
            g2.drawImage(coinImage,465,20,48,48,null);
        if(playerImage!=null){
            g2.drawImage(playerImage,300,200,200,200,null);
            g2.drawString("price:"+price,500,400);
        }
    }
    private void setButtons() {
        ButtonGroup bg=new ButtonGroup();
        mario.setBounds(100,100,100,30);
        luigi.setBounds(100,200,100,30);
        princess.setBounds(100,300,100,30);
        uniqueGirl.setBounds(100,400,100,30);
        poker.setBounds(100,500,100,30);
        back.setBounds(0,0,50,50);
        buy.setBounds(500,500,50,30);
        bg.add(mario);
        bg.add(luigi);
        bg.add(princess);
        bg.add(uniqueGirl);
        bg.add(poker);
        for (JRadioButton button:buttonList){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadImage();
                    repaint();
                }
            });
        }
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mario.setSelected(true);
                loadImage();
                card.cardLayout.show(card,"mainMenu");
            }
        });
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JRadioButton jRadioButton : buttonList) {
                    if(jRadioButton.isSelected()) {
                        user.userManager.buyRequest(jRadioButton.getText());
                        saveInfo();
                        break;
                    }
                }
            }
        });
        this.add(buy);
        this.add(back);
        this.add(mario);
        this.add(luigi);
        this.add(princess);
        this.add(uniqueGirl);
        this.add(poker);

    }
    private void loadImage(){
        try {
            if (mario.isSelected()) {
                playerImage = ImageIO.read(getClass().getResourceAsStream("/Images/Players/MarioRight1.png"));
                price = Mario.price;
            } else if (luigi.isSelected()) {
                playerImage = ImageIO.read(getClass().getResourceAsStream("/Images/Players/LuigiJumpRight.png"));
                price = Luigi.price;
            } else if (princess.isSelected()) {
                playerImage = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PrincessRight1.png"));
                price = Princess.price;
            } else if (uniqueGirl.isSelected()) {
                playerImage = ImageIO.read(getClass().getResourceAsStream("/Images/Players/UniqueGirlRight1.png"));
                price = UniqueGirl.price;
            } else if (poker.isSelected()) {
                playerImage = ImageIO.read(getClass().getResourceAsStream("/Images/Players/PokerRight2.png"));
                price = Poker.price;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setUser() {
        this.user = this.card.gM.lM.userManager.currentUser;
        this.repaint();
    }
    private void saveInfo(){
        File file = new File(user.getUserName() + ".json");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            user.userManager.objectMapper.writeValue(fileWriter,user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
