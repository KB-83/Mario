package Graphic.Models;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Models.Entity.*;
import Graphic.Models.Object.GuiCoinManager;
import Graphic.Models.Object.GuiPipeManager;
import Graphic.Models.Tiles.GuiTileManager;
import Graphic.Panels.GamePanel;
import Logic.Models.Entity.*;
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
//    @JsonIgnore
    public GuiCoinManager coinManager;
//    @JsonIgnore
    public GuiPipeManager pipeManager;
//    @JsonIgnore
    public GuiPlantManager plantManager;

    public GuiGameState(GamePanel gamePanel, GraphicManager gM,LogicGameState logicGameState){

        this.gamePanel = gamePanel;
//        this.gamePanel.setGuiGameState(this);
        this.gM = gM;
        this.logicGameState = logicGameState;
        setPlayer();
        this.background = new GuiTileManager(this);
        this.coinManager = new GuiCoinManager(this);
        this.pipeManager = new GuiPipeManager(this);
        this.plantManager = new GuiPlantManager(this);
    }
    public void paintAll(Graphics2D g2){
        background.draw(g2);
        plantManager.draw(g2);
        pipeManager.draw(g2);
        coinManager.draw(g2);
        guiPlayer.draw(g2);
    }

    public void sectionChanged() {
        this.background.loadMap();
        this.coinManager.loadCoinList();
        this.pipeManager.loadPipeList();
        this.plantManager.loadPlantList();
    }
    private void setPlayer(){
        String playerName = logicGameState.currentPlayer.name;
        switch (playerName){
            case "Mario":
                this.guiPlayer = new GuiMario(gM,this);
                break;
            case "Luigi":
                this.guiPlayer = new GuiLuigi(gM,this);
                break;
            case "Princess":
                this.guiPlayer = new GuiPrincess(gM,this);
                break;
            case "UniqueGirl":
                this.guiPlayer = new GuiUniqueGirl(gM,this);
                break;
            case "Poker":
                this.guiPlayer = new GuiPoker(gM,this);
                break;
        }

    }
}
