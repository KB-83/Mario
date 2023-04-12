package Logic.Models;

import Graphic.Models.GuiGameState;
import Logic.LogicManager;
import Logic.Models.Entity.Luigi;
import Logic.Models.Entity.Poker;
import Logic.Models.Entity.Princess;
import Logic.Models.Entity.UniqueGirl;
import Logic.Models.Tiles.CollisionChecker;
import Logic.Models.Tiles.Tile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserManager {
    public LogicManager lM;
    public User currentUser;

    public ObjectMapper objectMapper = new ObjectMapper();
    public UserManager(LogicManager lM){
        this.lM = lM;
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public boolean signInRequest(String userName,String pass) {
        File file = new File(userName+".json");
        try {
            if(!file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
//                User user = new User(userName,pass,this);
                //test
                User user = new User(userName,pass,this);
                userCleared(user);
                LogicGameState logicGameState1 = new LogicGameState(this.lM);
                currentUser.gameStatesList.add(logicGameState1);
                LogicGameState logicGameState2 = new LogicGameState(this.lM);
                currentUser.gameStatesList.add(logicGameState2);
                LogicGameState logicGameState3 = new LogicGameState(this.lM);
                currentUser.gameStatesList.add(logicGameState3);
                currentUser.currentGameState = logicGameState1;
                objectMapper.writeValue(fileWriter,currentUser);
                //test
                System.out.println("test from user manager");
                // test
                this.lM.gM.panelsManagerCard.lastGamesPanel.setLastGamesButtons();
                this.lM.gM.panelsManagerCard.newGamePanel.setLastGamesButtons();
                return true;
            }
            else {
                System.out.println("user does exist already.");
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean loginRequest(String userName,String pass) {
        File file = new File(userName + ".json");
        if (file.exists()) {
            try {
                if (objectMapper.readValue(file, User.class).getPassWord().equals(pass)) {
                    userCleared(objectMapper.readValue(file, User.class));
                    //test
                    this.lM.gM.panelsManagerCard.lastGamesPanel.setLastGamesButtons();
                    this.lM.gM.panelsManagerCard.newGamePanel.setLastGamesButtons();
                    return true;
                }
                else {
                    System.out.println("password is wrong!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("user does not exist.");
            return false;
        }

        return false;
    }
    private void userCleared(User user) {
        this.currentUser = user;
        //VERY IMP
        user.setUserManager(this);
//        System.out.println("here user cleard");
//        currentUser.currentGameState.currentPlayer.setCurrentUser(currentUser);
        this.lM.gM.panelsManagerCard.setCurrentUser(user);
    }
    public void update(){
        if (this.currentUser.currentGameState.isOver == false) {
            this.currentUser.currentGameState.update();
        }
        else {
            this.currentUser.currentGameState.loop.stop();
        }
    }
    public void newGameRequest(String lastGameMassage,String newGameMassage){
        for (int i = 0; i <currentUser.gameStatesList.size();i++) {
            if (currentUser.gameStatesList.get(i).massage.equals(lastGameMassage)) {
                currentUser.gameStatesList.remove(i);
                this.currentUser.setCurrentGameState(new LogicGameState(this.lM));
                currentUser.gameStatesList.add(i,currentUser.currentGameState);
                // test
//                this.currentUser.gameStatesList.add(currentUser.getCurrentGameState());
                this.currentUser.currentGameState.massage = newGameMassage;
                //
                this.currentUser.currentGameState.currentPlayer.setCurrentUser(this.currentUser);
//                this.lM.gM.guiUserManager.newGameRequest(this.lM.gM);
                // testt
//                System.out.println("here from user manager");
                break;
            }
        }
    }
    public void lastGamesRequest(String massage) {
        for (LogicGameState gameState:currentUser.gameStatesList){
            if (gameState.getMassage().equals(massage)){
                gameState.lM = lM;
                gameState.guiGameState = new GuiGameState(lM.gM.panelsManagerCard.gamePanel,lM.gM,gameState);
                gameState.background.logicGameState = gameState;
                currentUser.setCurrentGameState(gameState);
                gameState.currentPlayer.setCurrentUser(currentUser);
                gameState.currentPlayer.collisionChecker = new CollisionChecker(gameState.currentPlayer);
                gameState.currentPlayer.collisionChecker.player = gameState.currentPlayer;
                gameState.currentPlayer.collisionChecker.tileManager = gameState.background;
                gameState.guiGameState.logicGameState = gameState;
//                gameState.currentPlayer.setLogicG;
//                this.currentUser.selectedPlayer.setCurrentUser(this.currentUser);
                lM.gM.panelsManagerCard.gamePanel.setKeyListener(gameState.currentPlayer.getPlayerListener());
                break;
            }
        }
    }
//    public LogicGameState createANewGameState(){
//        this.logicGameState = new LogicGameState(this);
//        return new LogicGameState(this.lM);
//        this.gM.createANewGameState();
//    }
    public void sectionChanged() {
        countScore();
        this.currentUser.currentGameState.background.topLeftColInWorld = 0;
        this.currentUser.currentGameState.sectionNum++;
        System.out.println("section changed from user mnager");
        this.currentUser.currentGameState.guiGameState.sectionChanged();
    }
    public void buyRequest(String name){
        if (currentUser.ownedPlayers.contains(name)){
            System.out.println("already taken");
        }
        else {
            int coins = currentUser.coins;
            int price = 0;
            switch (name){
                case "Luigi":
                    price = Luigi.price;
                    break;
                case "Princess":
                    price = Princess.price;
                    break;
                case "UniqueGirl":
                    price = UniqueGirl.price;
                    break;
                case "Poker":
                    price = Poker.price;
                    break;
            }
            if (price<=coins){
                currentUser.coins -= price;
                currentUser.ownedPlayers.add(name);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lM.gM.panelsManagerCard.shopPanel.repaint();
                lM.gM.panelsManagerCard.profilePanel.setPlayersOption();
            }
            else {
                System.out.println("you dont have enough money");
            }
        }
    }
    public void countScore(){
//        به ازای هر سکه بدست آمده ۱۰ امتیاز
//        به ازای هر قلب ۲۰ امتیاز
//        به ازای هر دشمن کشته شده ۱۵ امتیاز
//        به ازای هر ثانیه باقیمانده از بازی ۱ امتیاز
        int coin = currentUser.currentGameState.coins;
        int hearts = currentUser.currentGameState.hearts;
        int time = currentUser.currentGameState.remainingTime;
        currentUser.getCurrentGameState().score+= 10 * coin + 20 * hearts + time;
        currentUser.currentGameState.coins = 0;
        currentUser.coins += coin;
    }
}
