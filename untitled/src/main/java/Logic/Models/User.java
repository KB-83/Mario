package Logic.Models;

import Graphic.Models.Entity.GuiPlayer;
import Graphic.Models.GuiUser;
import Logic.LogicManager;
import Logic.Models.Entity.Mario;
import Logic.Models.Entity.Player;

import java.util.ArrayList;
import java.util.List;

public class User {
    LogicManager lm;
    public List<LogicGameState> gameStatesList = new ArrayList<>();
    List<Player> ownedPlayers = new ArrayList<>();
    GuiUser guiUser;
    Player selectedPlayer;
    String userName;
    String passWord;
    int score;
    int highScore;
    int coins;
    int hearts;

    public User() {

    }
    public User(String userName,String passWord) {
        this.userName = userName;
        this.passWord = passWord;
//        Mario mario = new Mario();
//        this.selectedPlayer = mario;
//        this.ownedPlayers.add(mario);
//        LogicGameState logicGameState = new LogicGameState(this.lm);
//        this.gameStatesList.add(logicGameState);
//        this.selectedPlayer = logicGameState.player;

    }

//    public void update(){
//        this.selectedPlayer.update();
//    }

    public List<LogicGameState> getGameStatesList() {
        return gameStatesList;
    }

    public void setGameStatesList(List<LogicGameState> gameStatesList) {
        this.gameStatesList = gameStatesList;
    }

    public List<Player> getOwnedPlayers() {
        return ownedPlayers;
    }

    public void setOwnedPlayers(List<Player> ownedPlayers) {
        this.ownedPlayers = ownedPlayers;
    }

    public GuiUser getGuiUser() {
        return guiUser;
    }

    public void setGuiUser(GuiUser guiUser) {
        this.guiUser = guiUser;
    }

    public Player getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(Player selectedPlayer) {
        this.selectedPlayer = selectedPlayer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }
    public LogicManager getLm() {
        return lm;
    }

    public void setLm(LogicManager lm) {
        this.lm = lm;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
