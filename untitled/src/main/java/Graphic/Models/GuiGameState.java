package Graphic.Models;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Models.Entity.*;
import Graphic.Models.Object.GuiCoinManager;
import Graphic.Models.Object.GuiPipeManager;
import Graphic.Models.Tiles.GuiTileManager;
import Graphic.Panels.GamePanel;
import Logic.Models.Entity.Enemy;
import Logic.Models.LogicGameState;
import Util.GameLoop;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;
import java.util.List;

public class GuiGameState {
    @JsonIgnore
    public GraphicManager gM;
    @JsonIgnore
    public LogicGameState logicGameState;
    @JsonIgnore
    public GamePanel gamePanel;
    @JsonIgnore
    public GuiPlayer guiPlayer;
    List<Enemy> enemies;
    public GuiTileManager background;
    @JsonIgnore
    public GuiCoinManager coinManager;
    @JsonIgnore
    public GuiPipeManager pipeManager;

    public GuiGameState(GamePanel gamePanel, GraphicManager gM,LogicGameState logicGameState){

        this.gamePanel = gamePanel;
//        this.gamePanel.setGuiGameState(this);
        this.gM = gM;
        this.logicGameState = logicGameState;
        this.guiPlayer = new GuiUniqueGirl(this.gM, this);
        this.background = new GuiTileManager(this);
        this.coinManager = new GuiCoinManager(this);
        this.pipeManager = new GuiPipeManager(this);
    }
    public void paintAll(Graphics2D g2){
        background.draw(g2);
        pipeManager.draw(g2);
        coinManager.draw(g2);
        guiPlayer.draw(g2);
    }

    public void sectionChanged() {
        System.out.println("section changed from gui game state");
        this.background.loadMap();
        this.coinManager.loadCoinList();
        this.pipeManager.loadPipeList();
    }
}
