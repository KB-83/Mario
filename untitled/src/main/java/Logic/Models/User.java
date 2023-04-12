package Logic.Models;

//import Graphic.Models.GuiUser;
import Logic.LogicManager;
import Logic.Models.Entity.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class User {
    @JsonIgnore
    public UserManager userManager;
//    @JsonIgnore
    public LogicGameState currentGameState;
//    @JsonIgnore
    public List<LogicGameState> gameStatesList = new ArrayList<>();
    List<String> ownedPlayers = new ArrayList<>();
//    GuiUser guiUser;
    String selectedPlayer;
    String userName;
    String passWord;
    int highScore;
    int coins = 21100;

    public User() {

    }
    public User(String userName,String passWord,UserManager userManager) {
        this.userManager = userManager;
        this.userName = userName;
        this.passWord = passWord;
        this.ownedPlayers.add("Mario");
//        this.ownedPlayers.add("Luigi");
//        this.ownedPlayers.add("Princess");
//        this.ownedPlayers.add("UniqueGirl");
//        this.ownedPlayers.add("Poker");
        this.selectedPlayer = "Mario";

//        this.currentGameState = userManager.createANewGameState();
//        this.gameStatesList.add(c);

//        System.out.println("user"+selectedPlayer.name);
//        this.ownedPlayers.add(selectedPlayer);
//        this.ownedPlayers.add(new Mario(lm.logicGameState));

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
    public void changeSelectedPlayer(String name){
        System.out.println("here user");
        this.selectedPlayer = name;
    }

    public List<LogicGameState> getGameStatesList() {
        return gameStatesList;
    }

    public void setGameStatesList(List<LogicGameState> gameStatesList) {
        this.gameStatesList = gameStatesList;
    }

    public List<String> getOwnedPlayers() {
        return ownedPlayers;
    }

    public void setOwnedPlayers(List<String> ownedPlayers) {
        this.ownedPlayers = ownedPlayers;
    }

//    public GuiUser getGuiUser() {
//        return guiUser;
//    }
//
//    public void setGuiUser(GuiUser guiUser) {
//        this.guiUser = guiUser;
//    }

    public String getSelectedPlayer() {
        return selectedPlayer;
    }

    public void setSelectedPlayer(String selectedPlayer) {
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


    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public LogicGameState getCurrentGameState() {
        return currentGameState;
    }

    public void setCurrentGameState(LogicGameState currentGameState) {
        this.currentGameState = currentGameState;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
