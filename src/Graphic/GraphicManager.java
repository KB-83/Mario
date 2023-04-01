package Graphic;

import Graphic.Listeners.PlayerListener;
import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.GuiGameState;
import Graphic.Panels.Frame;
import Graphic.Panels.GamePanel;
import Graphic.Panels.PanelsManagerCard;
import Logic.LogicManager;

import javax.xml.bind.Unmarshaller;
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

//        this.gamePanel = frame.panelsManagerCard.gamePanel;
//        this.guiGameState = new GuiGameState(gamePanel,this);
//        this.gamePanel.setGuiGameState(guiGameState);
//        System.out.println(gameLoop.toString());
    }


    public void paintAll() {

        frame.paintAll();
    }
    public void startAGame() {

        this.guiGameState = new GuiGameState(panelsManagerCard.gamePanel,this);
        this.panelsManagerCard.gamePanel.setGuiGameState(guiGameState);

    }

}
