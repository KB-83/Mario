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
    @JsonIgnore
    public GameLoop loop;
    public Player currentPlayer;
    List<Enemy> enemies;
    public int cols =26;
    public int rows = 15;
    public int levelNum = 1;
    public int sectionNum = 1;
    public TileManager background;
    public CoinManager coinManager;
    public String massage = "newGame   ";
    public boolean isOver = false;
    int hearts = 3;
    int score = 0;
    public int coins = 0;
    int totalTimePerSection = 300;
    long lastStopThreadTime = System.nanoTime();
    int remainingTime;
    int passedTime;
//    public CollisionChecker collisionChecker;
    public LogicGameState(){}
    public LogicGameState(LogicManager lM){

        this.lM = lM;
        // asan ye vazi
        this.background = new TileManager(this);
        this.coinManager = new CoinManager(this);
        setPlayer();
//        this.lM.userManager.currentUser.selectedPlayer = this.currentPlayer;
//        this.lM.gM.panelsManagerCard.gamePanel.setKeyListener(currentPlayer.playerListener);
        this.currentPlayer.collisionChecker.tileManager = background;
        currentPlayer.logicGameState = this;

        //test
        guiGameState = new GuiGameState(this.lM.gM.panelsManagerCard.gamePanel,lM.gM,this);
//        selectedUser.player = player;

    }

    public void update(){
        if (loop.isRunning()){
        passedTime = (int) ((System.nanoTime() - lastStopThreadTime)/1000000000);
        }
        remainingTime = (int) (totalTimePerSection - passedTime);
        currentPlayer.update();
        checkIfOver();
    }

    private void checkIfOver() {
        currentPlayer.checkHearts();
        if(hearts <= 0 || sectionNum > 3){
            isOver = true;
            lM.userManager.currentUser.coins += this.coins;
            if(lM.userManager.currentUser.highScore < this.score){
                lM.userManager.currentUser.highScore = this.score;
            }
            try {
                lM.gM.panelsManagerCard.gamePanel.repaint();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.lM.gM.panelsManagerCard.cardLayout.show(lM.gM.panelsManagerCard,"mainMenu");
        }

    }
    public void setPlayer(){
        String playerName = lM.userManager.currentUser.selectedPlayer;
        switch (playerName){
            case "Mario":
                this.currentPlayer = new Mario(lM.userManager.currentUser);
                break;
            case "Luigi":
                this.currentPlayer = new Luigi(lM.userManager.currentUser);
                break;
            case "Princess":
                this.currentPlayer = new Princess(lM.userManager.currentUser);
                break;
            case "UniqueGirl":
                this.currentPlayer = new UniqueGirl(lM.userManager.currentUser);
                break;
            case "Poker":
                this.currentPlayer = new Poker(lM.userManager.currentUser);
                break;
        }

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

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public int getTotalTimePerSection() {
        return totalTimePerSection;
    }

    public void setTotalTimePerSection(int totalTimePerSection) {
        this.totalTimePerSection = totalTimePerSection;
    }

    public long getLastStopThreadTime() {
        return lastStopThreadTime;
    }

    public void setLastStopThreadTime(long lastStopThreadTime) {
        this.lastStopThreadTime = lastStopThreadTime;
    }

    public int getPassedTime() {
        return passedTime;
    }

    public void setPassedTime(int passedTime) {
        this.passedTime = passedTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

}
