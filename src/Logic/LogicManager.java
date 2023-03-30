package Logic;

import Graphic.GraphicManager;
import Logic.Models.Entity.Player;

public class LogicManager {

    private final GraphicManager gM;

    public LogicManager(){

        this.gM =new GraphicManager(this);
    }

    public void playerAction(String action, Player player){
        player.action(action);
    }

    public void updateAll(){}
}
