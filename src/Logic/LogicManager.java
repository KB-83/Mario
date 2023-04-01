package Logic;

import Graphic.GraphicManager;
import Logic.Models.LogicGameState;

public class LogicManager {

    public final GraphicManager gM;
    public LogicGameState logicGameState;

    public LogicManager(){
        // logic Game State Must be First
        this.gM =new GraphicManager(this);
//        this.logicGameState = new LogicGameState(this);
    }

    public void updateAll(){
        logicGameState.update();
    }
    public void startAGame(){

        this.logicGameState = new LogicGameState(this);
        this.gM.startAGame();
    }
}
