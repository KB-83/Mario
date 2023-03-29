package Logic;

import Graphic.GraphicManager;
import Logic.Models.Entity.Player;

public class LogicManager {

    private final GraphicManager gM;

    LogicManager(GraphicManager gM){
        this.gM =gM;
    }

    public void playerAction(String action, Player player){
        player.action(action);
    }
}
