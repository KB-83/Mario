package Graphic.Models;

import Graphic.GraphicManager;
import Logic.Models.User;

public class GuiUserManager {
    GraphicManager gM;
    GuiUser guiUser;
    User user;
    public GuiUserManager(GraphicManager gM){
        this.gM = gM;
    }
    public void createANewGameState(GraphicManager gM) {

//        this.guiGameState = new GuiGameState(panelsManagerCard.gamePanel,this);
//        this.panelsManagerCard.gamePanel.setGuiGameState(guiGameState);

    }
    public void setCurrentUser(User user){
        this.user = user;
        this.gM.panelsManagerCard.shopPanel.setUser();
        this.gM.panelsManagerCard.profilePanel.setUser();
        this.gM.panelsManagerCard.newGamePanel.setUser();
        this.gM.panelsManagerCard.lastGamesPanel.setUser();
    }
}
