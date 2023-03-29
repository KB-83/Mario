package Graphic;

import Graphic.Listeners.PlayerListener;
import Logic.LogicManager;

public class GraphicManager {

    private final LogicManager lM ;

    GraphicManager(LogicManager lM) {
        this.lM = lM;
    }

    public void sendPlayerListenerAction(String action) {
        lM.playerAction(action);
    }

}
