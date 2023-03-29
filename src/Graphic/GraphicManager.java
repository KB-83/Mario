package Graphic;

import Graphic.Listeners.PlayerListener;
import Logic.LogicManager;
import Logic.Models.Entity.Player;

public class GraphicManager {

    private final LogicManager lM ;

    GraphicManager(LogicManager lM) {
        this.lM = lM;
    }

    public void sendPlayerListenerAction(String action, Player player) {
        lM.playerAction(action,player);
    }

}
