package Graphic;

import Graphic.Models.GuiGameState;
import Graphic.Panels.Frame;
import Graphic.Panels.PanelsManagerCard;
import Logic.LogicManager;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.awt.*;


public class GraphicManager {
    @JsonBackReference
    public LogicManager lM ;
    Frame frame;
    public User currentUser;
    public PanelsManagerCard panelsManagerCard;
    Graphics2D g2;// maybe useful in feature
    public GuiGameState guiGameState;


    public GraphicManager(LogicManager lM) {

        this.lM = lM;
        this.frame = new Frame(this);
        this.panelsManagerCard = frame.panelsManagerCard;

    }


    public void paintAll() {

        frame.paintAll();
    }
    public void createANewGameState() {

        this.guiGameState = new GuiGameState(panelsManagerCard.gamePanel,this);
        this.panelsManagerCard.gamePanel.setGuiGameState(guiGameState);

    }
    public void setCurrentUser(User user){
        this.currentUser = user;
        this.panelsManagerCard.profilePanel.setUser(user);
        this.panelsManagerCard.shopPanel.setUser(user);
    }

}
