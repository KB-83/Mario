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
    List<Player> ownedPlayers = new ArrayList<>();
//    GuiUser guiUser;
    Player selectedPlayer;
    String userName;
    String passWord;
    int highScore;
    int coins = 100;

    public User() {

    }
    public User(String userName,String passWord,UserManager userManager) {
        this.userManager = userManager;
        this.userName = userName;
        this.passWord = passWord;
        UniqueGirl mario = new UniqueGirl(this);
        this.ownedPlayers.add(mario);
        this.selectedPlayer = mario;

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
//        System.out.println(name);
//            for (Player player:ownedPlayers){
//                if (player.name.equals(name)){
//                    this.selectedPlayer = player;
//                    this.lm.gM.panelsManagerCard.profilePanel.repaint();
//                    break;
//                }
//            }

    }

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

//    public GuiUser getGuiUser() {
//        return guiUser;
//    }
//
//    public void setGuiUser(GuiUser guiUser) {
//        this.guiUser = guiUser;
//    }

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
