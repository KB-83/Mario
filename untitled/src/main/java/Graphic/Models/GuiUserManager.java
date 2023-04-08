package Graphic.Models;

import Graphic.GraphicManager;
import Logic.Models.User;

public class GuiUserManager {
    GraphicManager gM;
    public GuiGameState guiGameState;
    GuiUser guiUser;
    User user;
    public GuiUserManager(GraphicManager gM){
        this.gM = gM;
    }
    public void newGameRequest(GraphicManager gM) {

        this.guiGameState = new GuiGameState(gM.panelsManagerCard.gamePanel,gM);
        this.gM.panelsManagerCard.gamePanel.setGuiGameState(guiGameState);

    }
    public void setCurrentUser(User user){
        this.user = user;
        this.gM.panelsManagerCard.shopPanel.setUser();
        this.gM.panelsManagerCard.profilePanel.setUser();
        this.gM.panelsManagerCard.newGamePanel.setUser();
        this.gM.panelsManagerCard.lastGamesPanel.setUser();
        this.gM.panelsManagerCard.gamePanel.setCurrentUser(user);
    }
    public void sectionChanged() {
        this.guiGameState.sectionChanged();
    }
}
