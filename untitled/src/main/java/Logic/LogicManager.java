package Logic;

import Graphic.GraphicManager;
import Logic.Models.LogicGameState;
import Logic.Models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogicManager {
    public final GraphicManager gM;
    public User currentUser;
    public LogicGameState logicGameState;
    ObjectMapper objectMapper = new ObjectMapper();

    public LogicManager(){
        this.gM =new GraphicManager(this);
    }

    public void updateAll(){
        logicGameState.update();
    }
    public void startAGame(){
        this.logicGameState = new LogicGameState(this);
        this.gM.startAGame();
    }
    public boolean signInRequest(String userName,String pass) {
        File file = new File(userName+".json");
        try {
            if(!file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                User user = new User(userName,pass);
                userCleared(user);
                objectMapper.writeValue(fileWriter,user);
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
        // why eror here?
//        user.setLm(this);
        this.gM.setCurrentUser(user);
    }
}
