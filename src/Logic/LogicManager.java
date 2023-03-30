package Logic;

import Graphic.GraphicManager;
import Graphic.Models.Entity.GuiPlayer;
import Logic.Models.Entity.Player;
import Logic.Models.LogicGameState;
import Util.GameLoop;

public class LogicManager {

    public final GraphicManager gM;
    public final LogicGameState logicGameState;

    public LogicManager(){
        // logic Game State Must be First
        this.logicGameState = new LogicGameState(this);
        this.gM =new GraphicManager(this);
    }

    public void playerAction(String action, GuiPlayer guiPlayer){
        //

        logicGameState.player.action(action);
    }

    public void updateAll(){}
}
