package Graphic;

import Graphic.Models.GuiGameState;
import Graphic.Models.GuiUserManager;
import Graphic.Panels.Frame;
import Graphic.Panels.PanelsManagerCard;
import Logic.LogicManager;
import Logic.Models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.awt.*;


public class GraphicManager {
    public LogicManager lM ;
    Frame frame;
    public PanelsManagerCard panelsManagerCard;

    public GuiGameState guiGameState;
    public GuiUserManager guiUserManager;


    public GraphicManager(LogicManager lM) {

        this.lM = lM;
        this.frame = new Frame(this);
        this.guiUserManager = new GuiUserManager(this);
        this.panelsManagerCard = frame.panelsManagerCard;

    }


    public void paintAll() {
        frame.paintAll();
    }


}
