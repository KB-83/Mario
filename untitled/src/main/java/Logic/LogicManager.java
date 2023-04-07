package Logic;

import Graphic.GraphicManager;
import Logic.Models.LogicGameState;
import Logic.Models.User;
import Logic.Models.UserManager;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogicManager {
    public final GraphicManager gM;
    public UserManager userManager;

    public LogicManager(){
        this.gM =new GraphicManager(this);
        this.userManager = new UserManager(this);
    }

    public void updateAll(){
        userManager.update();
    }

}
