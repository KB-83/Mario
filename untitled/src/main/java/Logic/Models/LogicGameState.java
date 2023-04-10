package Logic.Models;
import Graphic.Models.Entity.GuiLuigi;
import Graphic.Models.GuiGameState;
import Logic.LogicManager;
import Logic.Models.Entity.*;
import Logic.Models.Object.CoinManager;
import Logic.Models.Tiles.TileManager;
import Util.GameLoop;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class LogicGameState {

    @JsonIgnore
    public LogicManager lM;
    @JsonIgnore

    public GuiGameState guiGameState;
    private GameLoop loop;
    public Player currentPlayer;
    List<Enemy> enemies;
    public int cols =26;
    public int rows = 15;
    public int levelNum = 1;
    public int sectionNum = 1;
    public TileManager background;
    public CoinManager coinManager;
    public String massage = "no";
//    public CollisionChecker collisionChecker;
    public LogicGameState(){}
    public LogicGameState(LogicManager lM){

        this.lM = lM;
        // asan ye vazi

        this.background = new TileManager(this);
        this.coinManager = new CoinManager(this);
        this.currentPlayer = lM.userManager.currentUser.selectedPlayer;
        this.currentPlayer.collisionChecker.tileManager = background;
        currentPlayer.logicGameState = this;

        //test
        guiGameState = new GuiGameState(this.lM.gM.panelsManagerCard.gamePanel,lM.gM,this);
//        selectedUser.player = player;

    }

    public void update(){
        currentPlayer.update();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setLoop(GameLoop loop) {
        this.loop = loop;
    }

    public LogicManager getlM() {
        return lM;
    }

    public void setlM(LogicManager lM) {
        this.lM = lM;
    }

    public GuiGameState getGuiGameState() {
        return guiGameState;
    }

    public void setGuiGameState(GuiGameState guiGameState) {
        this.guiGameState = guiGameState;
    }

    public GameLoop getLoop() {
        return loop;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public int getSectionNum() {
        return sectionNum;
    }

    public void setSectionNum(int sectionNum) {
        this.sectionNum = sectionNum;
    }

    public TileManager getBackground() {
        return background;
    }

    public void setBackground(TileManager background) {
        this.background = background;
    }

    public CoinManager getCoinManager() {
        return coinManager;
    }

    public void setCoinManager(CoinManager coinManager) {
        this.coinManager = coinManager;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
