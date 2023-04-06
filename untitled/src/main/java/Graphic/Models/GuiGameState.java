package Graphic.Models;

import Graphic.GraphicManager;
import Graphic.Listeners.PlayerListener;
import Graphic.Models.Entity.*;
import Graphic.Models.Object.GuiCoinManager;
import Graphic.Models.Object.GuiPipeManager;
import Graphic.Models.Tiles.GuiTileManager;
import Graphic.Panels.GamePanel;
import Logic.Models.Entity.Enemy;
import Util.GameLoop;

import java.awt.*;
import java.util.List;

public class GuiGameState {
    public GraphicManager gM;
    public GamePanel gamePanel;
    public GameLoop loop;
    public GuiPlayer guiPlayer;
    List<Enemy> enemies;
    public GuiTileManager background;
    public GuiCoinManager coinManager;
    public GuiPipeManager pipeManager;

    public GuiGameState(GamePanel gamePanel, GraphicManager gM){

        this.gamePanel = gamePanel;
        this.gM = gM;
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

    public void setLoop(GameLoop loop) {
        this.loop = loop;
    }
}
