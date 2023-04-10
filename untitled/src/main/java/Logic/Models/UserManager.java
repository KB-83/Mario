package Logic.Models;

import Logic.LogicManager;
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
                this.currentUser = new User(userName,pass,this);
                userCleared(currentUser);
                LogicGameState logicGameState1 = new LogicGameState(this.lM);
                currentUser.gameStatesList.add(logicGameState1);
                LogicGameState logicGameState2 = new LogicGameState(this.lM);
                currentUser.gameStatesList.add(logicGameState2);
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
        this.lM.gM.panelsManagerCard.setCurrentUser(user);
    }
    public void update(){
        this.currentUser.currentGameState.update();
    }
    public void newGameRequest(String massage){
        for (int i = 0; i <currentUser.gameStatesList.size();i++) {
            if (currentUser.gameStatesList.get(i).massage.equals(massage)) {
                currentUser.gameStatesList.remove(i);
                this.currentUser.setCurrentGameState(new LogicGameState(this.lM));
                currentUser.gameStatesList.add(i,currentUser.currentGameState);
                // test
//                this.currentUser.gameStatesList.add(currentUser.getCurrentGameState());
                this.currentUser.currentGameState.massage = massage;
                //
                this.currentUser.selectedPlayer.setCurrentUser(this.currentUser);
//                this.lM.gM.guiUserManager.newGameRequest(this.lM.gM);
                // testt
                System.out.println("here from user manager");
                break;
            }
        }
    }
    public void lastGamesRequest() {}
//    public LogicGameState createANewGameState(){
//        this.logicGameState = new LogicGameState(this);
//        return new LogicGameState(this.lM);
//        this.gM.createANewGameState();
//    }
    public void sectionChanged() {
        this.currentUser.currentGameState.background.topLeftColInWorld = 0;
        this.currentUser.currentGameState.sectionNum++;
        System.out.println("section changed from user mnager");
        this.currentUser.currentGameState.guiGameState.sectionChanged();
    }
    public void buyRequest(String name){
        System.out.println(name);
    }
}
