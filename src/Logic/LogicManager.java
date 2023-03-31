package Logic;

import Graphic.GraphicManager;
import Logic.Models.LogicGameState;

public class LogicManager {

    public final GraphicManager gM;
    public final LogicGameState logicGameState;

    public LogicManager(){
        // logic Game State Must be First
        this.logicGameState = new LogicGameState(this);
        this.gM =new GraphicManager(this);
    }

    public void updateAll(){
        logicGameState.update();
    }
}
