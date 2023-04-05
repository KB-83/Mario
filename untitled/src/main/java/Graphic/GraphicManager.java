package Graphic;

import Graphic.Models.GuiGameState;
import Graphic.Panels.Frame;
import Graphic.Panels.PanelsManagerCard;
import Logic.LogicManager;
import java.awt.*;


public class GraphicManager {

    public LogicManager lM ;
    Frame frame;
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
    public void startAGame() {

        this.guiGameState = new GuiGameState(panelsManagerCard.gamePanel,this);
        this.panelsManagerCard.gamePanel.setGuiGameState(guiGameState);

    }

}
